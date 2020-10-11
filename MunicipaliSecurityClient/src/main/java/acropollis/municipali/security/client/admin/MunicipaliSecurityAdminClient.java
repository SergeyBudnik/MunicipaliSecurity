package acropollis.municipali.security.client.admin;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.client.exceptions.MunicipaliSecurityCredentialsViolationException;
import acropollis.municipali.security.client.exceptions.MunicipaliSecurityNetworkException;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;

import java.util.List;

public interface MunicipaliSecurityAdminClient {
    List<MunicipaliUserInfo> getAllUsers(String rootUrl, String authToken) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException;

    MunicipaliUserInfo getUser(String rootUrl, String authToken, String login) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException;

    void createClient(String rootUrl, String authToken, MunicipaliUser user) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException;

    void editClient(String rootUrl, String authToken, MunicipaliUser user) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException;

    void deleteClient(String rootUrl, String authToken, String login) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException;
}
