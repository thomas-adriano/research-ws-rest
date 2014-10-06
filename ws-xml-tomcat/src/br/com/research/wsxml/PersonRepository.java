package br.com.research.wsxml;

import br.com.research.rest.Person;
import br.com.research.rest.Repository;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Thomas on 04/10/2014.
 */
@WebService
public class PersonRepository {

    private static final String COLLECTION_NAME = "person";

    private Repository repo;

    public PersonRepository() {
        repo = new Repository("resttest", "localhost", 27017);
    }

    public PersonRepository(String dbName, String hostName, int port) {
        repo = new Repository(dbName, hostName, port);
    }

    @WebMethod
    public String includePerson(String name, String surname) {
        String result = repo.insert(new Person(name, surname), COLLECTION_NAME);
        return result;
    }

}
