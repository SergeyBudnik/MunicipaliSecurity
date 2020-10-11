package acropollis.municipali.security.client.user;

import acropollis.municipali.security.client.exceptions.MunicipaliSecurityCredentialsViolationException;
import acropollis.municipali.security.client.exceptions.MunicipaliSecurityNetworkException;
import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;

public interface MunicipaliSecurityUserClient {
    MunicipaliUserToken login(String rootUrl, MunicipaliUserCredentials credentials) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException;

    void logout(String rootUrl, String authToken) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException;

    MunicipaliUserInfo getUserInfo(String rootUrl, String authToken) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException;
}
