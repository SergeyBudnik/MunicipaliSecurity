package acropollis.municipali.security.server.rest_service.user;

import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;
import acropollis.municipali.security.server.exceptions.ForbiddenException;
import acropollis.municipali.security.server.service.access.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserRestServiceImpl implements SecurityUserRestService {
    @Autowired
    private AccessService accessService;

    @Override
    public MunicipaliUserToken login(MunicipaliUserCredentials credentials) {
        return accessService.login(credentials).orElseThrow(ForbiddenException::new);
    }

    @Override
    public void logout(String authToken) {
        accessService.logoff(authToken);
    }

    @Override
    public MunicipaliUserInfo getUserInfo(String authToken) {
        return accessService
                .getUserInfo(authToken)
                .orElseThrow(ForbiddenException::new);
    }
}
