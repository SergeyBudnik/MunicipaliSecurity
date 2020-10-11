package acropollis.municipali.security.server.rest_service.user;

import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;

public interface SecurityUserRestService {
    MunicipaliUserToken login(MunicipaliUserCredentials credentials);
    void logout(String authToken);
    MunicipaliUserInfo getUserInfo(String authToken);
}

