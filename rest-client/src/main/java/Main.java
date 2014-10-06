import br.com.research.rest.PersonRestClient;

/**
 * Created by Thomas on 05/10/2014.
 */
public class Main {

    public static void main(String[] args) {

        PersonRestClient cl = new PersonRestClient();

//        interate(cl, 1);
//        interate(cl, 10);
//        interate(cl, 100);
//        interate(cl, 1000);
        interate(cl, 10000);
//6781
    }

    public static void interate(PersonRestClient cl, int times) {
        long init = System.currentTimeMillis();
        int lastIndex = -1;
        try {
            for (int i = 0; i < times; i++) {
                cl.includePerson("resty" + i, "ied" + i);
                lastIndex = i;
            }
        } finally {
            long end = System.currentTimeMillis();
            long diff = end - init;
            System.out.println(times+ " took: " + diff);
            System.out.println("lastIndex: "+lastIndex);
        }
    }
}
