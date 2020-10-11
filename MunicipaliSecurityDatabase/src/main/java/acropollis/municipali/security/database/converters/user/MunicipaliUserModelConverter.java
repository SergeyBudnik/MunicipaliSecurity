package acropollis.municipali.security.database.converters.user;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.database.model.MunicipaliUserModel;

public class MunicipaliUserModelConverter {
    public static MunicipaliUser convert(MunicipaliUserModel userModel) {
        MunicipaliUser user = new MunicipaliUser(); {
            user.setLogin(userModel.getLogin());
            user.setPassword(userModel.getPassword());
            user.setAccessLevel(userModel.getAccessLevel());
        }

        return user;
    }
}
