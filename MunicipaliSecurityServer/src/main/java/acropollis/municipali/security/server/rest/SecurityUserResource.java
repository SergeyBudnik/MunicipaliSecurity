package acropollis.municipali.security.server.rest;

import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;
import acropollis.municipali.security.server.rest_service.user.SecurityUserRestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "User", description = " ")
public class SecurityUserResource {
    @Autowired
    private SecurityUserRestService securityUserRestService;

    @GetMapping("/{authToken}")
    public MunicipaliUserInfo getUserInfo(
            @PathVariable String authToken
    ) {
        return securityUserRestService.getUserInfo(authToken);
    }

    @PostMapping("")
    public MunicipaliUserToken login(
            @RequestBody MunicipaliUserCredentials credentials
    ) {
        return securityUserRestService.login(credentials);
    }

    @DeleteMapping("/{authToken}")
    public void logout(
            @PathVariable String authToken
    ) {
        securityUserRestService.logout(authToken);
    }
}
