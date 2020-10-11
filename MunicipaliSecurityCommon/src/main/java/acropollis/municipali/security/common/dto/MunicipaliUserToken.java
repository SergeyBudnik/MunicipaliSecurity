package acropollis.municipali.security.common.dto;

import lombok.Data;

@Data
public class MunicipaliUserToken {
    private String token;
    private long validTill;
}
