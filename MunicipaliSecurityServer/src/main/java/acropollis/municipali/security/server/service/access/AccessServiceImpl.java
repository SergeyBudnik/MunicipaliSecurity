package acropollis.municipali.security.server.service.access;

import acropollis.municipali.security.common.dto.*;
import acropollis.municipali.security.server.exceptions.ForbiddenException;
import acropollis.municipali.security.server.service.user.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AccessServiceImpl implements AccessService {
    @Data
    private static class MunicipaliUserInfoAndToken {
        private MunicipaliUserInfo userInfo;
        private MunicipaliUserToken token;
    }

    private static final long TOKEN_VALID_DURATION = 365 * 24 * 3600 * 1000L;

    private final SecureRandom secureRandom = new SecureRandom();

    @Autowired
    private UserService userService;

    private Map<String, MunicipaliUserInfoAndToken> userInfoByToken = new ConcurrentHashMap<>();

    @Transactional(readOnly = true)
    @Override
    public Optional<MunicipaliUserToken> login(MunicipaliUserCredentials credentials) {
        Optional<MunicipaliUser> userOptional = userService.getUser(credentials.getLogin());

        if (!userOptional.isPresent()) {
            return Optional.empty();
        }

        MunicipaliUser user = userOptional.get();

        if (!Objects.equals(user.getPassword(), credentials.getPassword())) {
            throw new ForbiddenException();
        }

        String authToken = generateAuthToken();

        MunicipaliUserToken userToken = new MunicipaliUserToken(); {
            userToken.setToken(authToken);
            userToken.setValidTill(new Date().getTime() + TOKEN_VALID_DURATION);
        }

        MunicipaliUserInfoAndToken userInfoAndToken = new MunicipaliUserInfoAndToken(); {
            userInfoAndToken.setToken(userToken);
            userInfoAndToken.setUserInfo(user.toUserInfo());
        }

        userInfoByToken.put(authToken, userInfoAndToken);

        return Optional.of(userToken);
    }

    @Override
    public void logoff(String authToken) {
        userInfoByToken.remove(authToken);
    }

    @Override
    public Optional<MunicipaliUserInfo> getUserInfo(String authToken) {
        MunicipaliUserInfoAndToken userInfoAndToken = userInfoByToken.get(authToken);

        if (userInfoAndToken == null) {
            return Optional.empty();
        }

        if (userInfoAndToken.getToken().getValidTill() < new Date().getTime()) {
            userInfoByToken.remove(authToken);

            return Optional.empty();
        }

        return Optional.of(userInfoAndToken.getUserInfo());
    }

    private String generateAuthToken() {
        return new BigInteger(130, secureRandom).toString(32);
    }
}
