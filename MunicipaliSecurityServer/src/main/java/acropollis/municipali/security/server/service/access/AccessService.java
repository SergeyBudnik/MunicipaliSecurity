package acropollis.municipali.security.server.service.access;

import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;

import java.util.Optional;

public interface AccessService {
    Optional<MunicipaliUserToken> login(MunicipaliUserCredentials credentials);
    void logoff(String authToken);
    Optional<MunicipaliUserInfo> getUserInfo(String authToken);
}
