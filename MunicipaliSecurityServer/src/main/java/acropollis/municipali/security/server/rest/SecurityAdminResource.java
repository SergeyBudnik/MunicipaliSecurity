package acropollis.municipali.security.server.rest;

import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.server.exceptions.ForbiddenException;
import acropollis.municipali.security.server.rest_service.admin.SecurityAdminRestService;
import acropollis.municipali.security.server.service.access.AccessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin", description = " ")
public class SecurityAdminResource {
    @Autowired
    private SecurityAdminRestService securityAdminRestService;

    @Autowired
    private AccessService accessService;

    @GetMapping("")
    public List<MunicipaliUserInfo> getAllUsers(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken
    ) {
        return securityAdminRestService.getAllUsers(
                accessService.getUserInfo(authToken).orElseThrow(ForbiddenException::new)
        );
    }

    @GetMapping("/{login}")
    public MunicipaliUserInfo getUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @PathVariable String login
    ) {
        return securityAdminRestService.getUser(
                accessService.getUserInfo(authToken).orElseThrow(ForbiddenException::new),
                login
        );
    }

    @PostMapping("")
    public void createUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @RequestBody MunicipaliUser user
    ) {
        securityAdminRestService.createUser(
                accessService.getUserInfo(authToken).orElseThrow(ForbiddenException::new),
                user
        );
    }

    @PutMapping("")
    public void editUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @RequestBody MunicipaliUser user
    ) {
        securityAdminRestService.editUser(
                accessService.getUserInfo(authToken).orElseThrow(ForbiddenException::new),
                user
        );
    }

    @DeleteMapping("/{login}")
    public void deleteUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @PathVariable String login
    ) {
        securityAdminRestService.deleteUser(
                accessService.getUserInfo(authToken).orElseThrow(ForbiddenException::new),
                login
        );
    }
}
