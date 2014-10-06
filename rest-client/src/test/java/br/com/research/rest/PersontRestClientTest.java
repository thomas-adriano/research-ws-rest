package br.com.research.rest;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Thomas on 02/10/2014.
 */
public class PersontRestClientTest {

    /* root path of the app. e.g.: http://localhost:8080/myapp/ */
    public static final URI REST_RESOURCE_URI = createURI();
    /* relative path of the target resource. e.g.: http://localhost:8080/myapp/person*/
    public static final String PATH = "person";

    private static final URI createURI() {
        try {
            return new URI("http://localhost:8080/myapp");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @Test
    public void getPersonTest() {
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(REST_RESOURCE_URI);
        String responseMsg = target.path(PATH).request().get(String.class);
        System.out.println(responseMsg);
    }
}
