package acropollis.municipali.security.client.user;

import acropollis.municipali.security.client.exceptions.MunicipaliSecurityCredentialsViolationException;
import acropollis.municipali.security.client.exceptions.MunicipaliSecurityNetworkException;
import acropollis.municipali.security.common.dto.MunicipaliUserCredentials;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import acropollis.municipali.security.common.dto.MunicipaliUserToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.MediaType;

@SuppressWarnings("unused")
public class MunicipaliSecurityUserClientImpl implements MunicipaliSecurityUserClient {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public MunicipaliUserToken login(String rootUrl, MunicipaliUserCredentials credentials) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/user");

            ClientResponse response = resource
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .post(ClientResponse.class, mapper.writeValueAsString(credentials));

            HttpStatus status = HttpStatus.valueOf(response.getStatus());

            if (status != HttpStatus.OK) {
                if (status == HttpStatus.FORBIDDEN) {
                    throw new MunicipaliSecurityCredentialsViolationException();
                } else {
                    throw new MunicipaliSecurityNetworkException();
                }
            }

            return mapper.readValue(response.getEntity(String.class), MunicipaliUserToken.class);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        } catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    @Override
    public void logout(String rootUrl, String authToken) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/user/" + authToken);

            ClientResponse response = resource
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .delete(ClientResponse.class);

            HttpStatus status = HttpStatus.valueOf(response.getStatus());

            if (status != HttpStatus.OK) {
                if (status == HttpStatus.FORBIDDEN) {
                    throw new MunicipaliSecurityCredentialsViolationException();
                } else {
                    throw new MunicipaliSecurityNetworkException();
                }
            }
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        } catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    @Override
    public MunicipaliUserInfo getUserInfo(String rootUrl, String authToken) throws
            MunicipaliSecurityCredentialsViolationException,
            MunicipaliSecurityNetworkException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/user/" + authToken);

            ClientResponse response = resource
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);

            HttpStatus status = HttpStatus.valueOf(response.getStatus());

            if (status != HttpStatus.OK) {
                if (status == HttpStatus.FORBIDDEN) {
                    throw new MunicipaliSecurityCredentialsViolationException();
                } else {
                    throw new MunicipaliSecurityNetworkException();
                }
            }

            return mapper.readValue(response.getEntity(String.class), MunicipaliUserInfo.class);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        } catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }
}
