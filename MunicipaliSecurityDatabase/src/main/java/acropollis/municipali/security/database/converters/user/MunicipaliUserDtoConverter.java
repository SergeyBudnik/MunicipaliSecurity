package acropollis.municipali.security.database.converters.user;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.database.model.MunicipaliUserModel;

public class MunicipaliUserDtoConverter {
    public static MunicipaliUserModel convert(MunicipaliUser user) {
        MunicipaliUserModel userModel = new MunicipaliUserModel(); {
            userModel.setLogin(user.getLogin());
            userModel.setPassword(user.getPassword());
            userModel.setAccessLevel(user.getAccessLevel());
        }

        return userModel;
    }
}
