package acropollis.municipali.security.server.service.user;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.database.converters.user.MunicipaliUserDtoConverter;
import acropollis.municipali.security.database.converters.user.MunicipaliUserModelConverter;
import acropollis.municipali.security.database.dao.MunicipaliUserDao;
import acropollis.municipali.security.server.exceptions.EntityAlreadyExistsException;
import acropollis.municipali.security.server.exceptions.EntityDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MunicipaliUserDao municipaliUserDao;

    @Transactional(readOnly = true)
    @Override
    public List<MunicipaliUser> getAllUsers() {
        return municipaliUserDao
                .findAll()
                .stream()
                .map(MunicipaliUserModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MunicipaliUser> getUser(String login) {
        return Optional
                .ofNullable(municipaliUserDao.findOne(login))
                .map(MunicipaliUserModelConverter::convert);
    }

    @Transactional
    @Override
    public void createUser(MunicipaliUser user) {
        boolean userExists = municipaliUserDao.findOne(user.getLogin()) != null;

        if (userExists) {
            throw new EntityAlreadyExistsException();
        }

        municipaliUserDao.save(MunicipaliUserDtoConverter.convert(user));
    }

    @Override
    public void editUser(MunicipaliUser user) {
        boolean userExists = municipaliUserDao.findOne(user.getLogin()) != null;

        if (!userExists) {
            throw new EntityDoesNotExistException();
        }

        municipaliUserDao.save(MunicipaliUserDtoConverter.convert(user));
    }

    @Transactional
    @Override
    public void deleteUser(String login) {
        boolean userExists = municipaliUserDao.findOne(login) != null;

        if (!userExists) {
            throw new EntityDoesNotExistException();
        }

        municipaliUserDao.delete(login);
    }
}
