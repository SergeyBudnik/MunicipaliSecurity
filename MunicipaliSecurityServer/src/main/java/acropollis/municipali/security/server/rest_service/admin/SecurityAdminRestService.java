package acropollis.municipali.security.server.rest_service.admin;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;

import java.util.List;

public interface SecurityAdminRestService {
    List<MunicipaliUserInfo> getAllUsers(MunicipaliUserInfo currentUser);
    MunicipaliUserInfo getUser(MunicipaliUserInfo currentUser, String login);
    void createUser(MunicipaliUserInfo currentUser, MunicipaliUser user);
    void editUser(MunicipaliUserInfo currentUser, MunicipaliUser user);
    void deleteUser(MunicipaliUserInfo currentUser, String login);
}
