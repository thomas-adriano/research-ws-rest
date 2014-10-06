package br.com.research.rest;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.NoSuchElementException;

/**
 * Created by Thomas on 04/10/2014.
 */
public class Repository {

    private MongoClient mongo;
    private DB db;
    private boolean isInitialized = false;

    private String dbName;
    private String hostName;
    private int port;

    public Repository(String dbName, String hostName, int port) {
        this.dbName = dbName;
        this.hostName = hostName;
        this.port = port;
    }

    private void initialize(String dbName, String hostname, int port) {
        try {
            mongo = new MongoClient(hostname, port);
            db = mongo.getDB(dbName);
            isInitialized = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public <T extends Tupleable> String insert(T element, String collection) {
        if (!isInitialized) {
            initialize(dbName, hostName, port);
        }
        DBCollection table = db.getCollection(collection);
        BasicDBObject document = new BasicDBObject();

        Tuple<?> tuple = element.next();
        while (tuple != null) {
            document.put((String) tuple.getKey(), (String) tuple.getElement());
            try {
                tuple = element.next();
            } catch (NoSuchElementException ex) {
                tuple = null;
            }
        }

        WriteResult result = table.insert(document);
        return result.toString();
    }

    public <T> String delete(T document) {
        if (!isInitialized) {
            initialize(dbName, hostName, port);
        }


        return "";
    }

    public <T> String update(T document) {
        if (!isInitialized) {
            initialize(dbName, hostName, port);
        }


        return "";
    }

    public <T> T get(T document) {
        if (!isInitialized) {
            initialize(dbName, hostName, port);
        }


        return null;
    }

}
