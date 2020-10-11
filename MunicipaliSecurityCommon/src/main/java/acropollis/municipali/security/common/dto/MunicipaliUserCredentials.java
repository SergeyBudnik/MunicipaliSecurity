package acropollis.municipali.security.common.dto;

import lombok.Data;

@Data
public class MunicipaliUserCredentials {
    private String login;
    private String password;
}
