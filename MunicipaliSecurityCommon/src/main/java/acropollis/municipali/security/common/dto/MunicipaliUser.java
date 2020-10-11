package acropollis.municipali.security.common.dto;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class MunicipaliUser {
    private String login;
    private String password;
    private MunicipaliUserAccessLevel accessLevel;

    @Transient
    public MunicipaliUserInfo toUserInfo() {
        MunicipaliUserInfo userInfo = new MunicipaliUserInfo(); {
            userInfo.setLogin(login);
            userInfo.setAccessLevel(accessLevel);
        }

        return userInfo;
    }
}
