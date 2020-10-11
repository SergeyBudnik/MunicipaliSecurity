package acropollis.municipali.security.client.admin;

import acropollis.municipali.security.client.exceptions.MunicipaliSecurityCredentialsViolationException;
import acropollis.municipali.security.client.exceptions.MunicipaliSecurityNetworkException;
import acropollis.municipali.security.common.dto.MunicipaliUser;
import acropollis.municipali.security.common.dto.MunicipaliUserInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.MediaType;
import java.util.List;

@SuppressWarnings("unused")
public class MunicipaliSecurityAdminClientImpl implements MunicipaliSecurityAdminClient {
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<MunicipaliUserInfo> getAllUsers(String rootUrl, String authToken) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/admin");

            ClientResponse response = getResourceBuilder(resource, authToken)
                    .get(ClientResponse.class);

            checkStatus(response);

            return mapper.readValue(response.getEntity(String.class), new TypeReference<List<MunicipaliUserInfo>>() {});
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        }  catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    public MunicipaliUserInfo getUser(String rootUrl, String authToken, String login) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/admin/" + login);

            ClientResponse response = getResourceBuilder(resource, authToken)
                    .get(ClientResponse.class);

            checkStatus(response);

            return mapper.readValue(response.getEntity(String.class), MunicipaliUserInfo.class);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        }  catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    @Override
    public void createClient(String rootUrl, String authToken, MunicipaliUser user) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/admin");

            ClientResponse response = getResourceBuilder(resource, authToken)
                    .post(ClientResponse.class, mapper.writeValueAsString(user));

            checkStatus(response);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        }  catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    @Override
    public void editClient(String rootUrl, String authToken, MunicipaliUser user) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/admin");

            ClientResponse response = getResourceBuilder(resource, authToken)
                    .put(ClientResponse.class, mapper.writeValueAsString(user));

            checkStatus(response);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        }  catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    @Override
    public void deleteClient(String rootUrl, String authToken, String login) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        try {
            WebResource resource = Client.create().resource(rootUrl + "/admin/" + login);

            ClientResponse response = getResourceBuilder(resource, authToken)
                    .delete(ClientResponse.class);

            checkStatus(response);
        } catch (MunicipaliSecurityCredentialsViolationException | MunicipaliSecurityNetworkException e) {
            throw e;
        } catch (Exception e) {
            throw new MunicipaliSecurityNetworkException();
        }
    }

    private WebResource.Builder getResourceBuilder(WebResource resource, String authToken) {
        return resource
                .header("Authorization", authToken)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);
    }

    private void checkStatus(ClientResponse response) throws
            MunicipaliSecurityNetworkException,
            MunicipaliSecurityCredentialsViolationException {

        HttpStatus status = HttpStatus.valueOf(response.getStatus());

        if (status != HttpStatus.OK) {
            if (status == HttpStatus.FORBIDDEN) {
                throw new MunicipaliSecurityCredentialsViolationException();
            } else {
                throw new MunicipaliSecurityNetworkException();
            }
        }
    }
}
