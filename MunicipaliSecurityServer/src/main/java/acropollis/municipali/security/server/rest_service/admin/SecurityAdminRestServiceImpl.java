package acropollis.municipali.security.server.rest_service.admin;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityAdminRestServiceImpl implements SecurityAdminRestService {
    @Autowired
    private UserService userService;

    @Override
    public List<MunicipaliUserInfo> getAllUsers(MunicipaliUserInfo currentUser) {
        return userService
                .getAllUsers()
                .stream()
                .map(MunicipaliUser::toUserInfo)
                .collect(Collectors.toList());
    }

    @Override
    public MunicipaliUserInfo getUser(MunicipaliUserInfo currentUser, String login) {
        return userService
                .getUser(login)
                .map(MunicipaliUser::toUserInfo)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void createUser(MunicipaliUserInfo currentUser, MunicipaliUser user) {
        userService.createUser(user);
    }

    @Override
    public void editUser(MunicipaliUserInfo currentUser, MunicipaliUser user) {
        userService.editUser(user);
    }

    @Override
    public void deleteUser(MunicipaliUserInfo currentUser, String login) {
        userService.deleteUser(login);
    }
}
