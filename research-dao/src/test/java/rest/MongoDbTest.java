package rest;

import com.mongodb.*;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by Thomas on 03/10/2014.
 */
public class MongoDbTest {

    private static final String DB_NAME = "resttest";
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 27017;
    private static final String COLLECTION = "person";
    private MongoClient mongo;
    private DB db;

    @Before
    public void setUp() throws UnknownHostException {
        mongo = new MongoClient(HOSTNAME, PORT);
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDB(DB_NAME);
    }


    @Test
    public void getTableTest() {
        DBCollection table = db.getCollection(COLLECTION);

        Set<String> collections = db.getCollectionNames();

        for (String coll : collections) {
            System.out.println(coll);
        }
    }

    @Test
    public void insertTest() {
        DBCollection table = db.getCollection(COLLECTION);
        BasicDBObject document = new BasicDBObject();
        document.put("name", "jake");
        document.put("surname", "pelin");
        table.insert(document);
        printCollectionContent(table.find());
    }

    @Test
    public void updateTest() {
        DBCollection table = db.getCollection(COLLECTION);

        BasicDBObject query = new BasicDBObject();
        query.put("name", "jake");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "jake-updated");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
        printCollectionContent(table.find());
    }

    @Test
    public void findTest() {
        DBCollection table = db.getCollection(COLLECTION);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "thomas");

        printCollectionContent(table.find(searchQuery));
    }

    @Test
    public void deleteTest() {
        DBCollection table = db.getCollection(COLLECTION);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "thomas");

        table.remove(searchQuery);

        printCollectionContent(table.find(searchQuery));
    }

    private void printCollectionContent(DBCursor documents) {
        documents.forEach(
                (document) -> System.out.println(document)
        );
    }

}
