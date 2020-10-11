package acropollis.municipali.security.database.model;

import acropollis.municipali.security.common.dto.MunicipaliUserAccessLevel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MUNICIPALI_USER")
public class MunicipaliUserModel {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCESS_LEVEL")
    private MunicipaliUserAccessLevel accessLevel;
}
