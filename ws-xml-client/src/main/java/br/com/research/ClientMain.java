package br.com.research;

import br.com.research.wsxml.PersonRepository;
import br.com.research.wsxml.PersonRepositoryService;

/**
 * Created by Thomas on 05/10/2014.
 */
public class ClientMain {

    public static void main(String[] args) {
        PersonRepositoryService service = new PersonRepositoryService();
        PersonRepository repoService = service.getPersonRepositoryPort();

        iterate(repoService, 1);
        iterate(repoService, 10);
        iterate(repoService, 100);
        iterate(repoService, 1000);
    }

    public static void iterate(PersonRepository repoService, int times) {
        long init = System.currentTimeMillis();

        for (int i = 0; i < times; i++) {
            repoService.includePerson("aname" + i, "asurname" + i);
        }

        long end = System.currentTimeMillis();

        long diff = end - init;

        System.out.println(times + " took " + diff);
    }

}
