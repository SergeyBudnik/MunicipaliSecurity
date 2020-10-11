package acropollis.municipali.security.common.dto;

import lombok.Data;

@Data
public class MunicipaliUserInfo {
    private String login;
    private MunicipaliUserAccessLevel accessLevel;
}
