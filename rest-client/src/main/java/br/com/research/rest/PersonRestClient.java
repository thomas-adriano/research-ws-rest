package br.com.research.rest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Thomas on 02/10/2014.
 */
public class PersonRestClient {

    /* root path of the app. e.g.: http://localhost:8080/myapp/ */
    public static final URI REST_RESOURCE_URI = createURI();
    /* relative path of the target resource. e.g.: http://localhost:8080/myapp/person*/
    public static final String PATH = "people";
    private Client cli;
    private WebTarget target;
    private Invocation.Builder request;

    private static final URI createURI() {
        try {
            return new URI("http://localhost:3000/api");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public String getPersons() {
        instantianteClient();
        WebTarget target = cli.target(REST_RESOURCE_URI);
        String responseMsg = target.path(PATH).request().get(String.class);
        return responseMsg;
    }

    public Response includePerson(String name, String surName) {
        if (request == null) {
            createRequest();
        }

        MultivaluedMap<String, String> m = new MultivaluedHashMap<>();
        m.add("name", name);
        m.add("surname", surName);
        Entity entity = Entity.form(m);

        return request.post(entity);
    }

    private void createRequest() {
        createWebTarget();
        if (request == null) {
            request = target.request();
        }
    }

    private void createWebTarget() {
        instantianteClient();
        if (target == null) {
            target = cli.target(REST_RESOURCE_URI).path(PATH);
        }
    }

    private void instantianteClient() {
        if (cli == null) {
            cli = ClientBuilder.newClient();
        }
    }

}
