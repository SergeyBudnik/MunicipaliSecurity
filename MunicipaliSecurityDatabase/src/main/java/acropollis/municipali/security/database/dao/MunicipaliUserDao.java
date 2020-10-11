package acropollis.municipali.security.database.dao;

import acropollis.municipali.security.database.model.MunicipaliUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipaliUserDao extends JpaRepository<MunicipaliUserModel, String> {
}
