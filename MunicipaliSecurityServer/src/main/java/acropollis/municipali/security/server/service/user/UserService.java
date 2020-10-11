package acropollis.municipali.security.server.service.user;

import acropollis.municipali.security.common.dto.MunicipaliUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<MunicipaliUser> getAllUsers();
    Optional<MunicipaliUser> getUser(String login);
    void createUser(MunicipaliUser user);
    void editUser(MunicipaliUser user);
    void deleteUser(String login);
}
