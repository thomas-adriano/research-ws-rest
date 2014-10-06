package br.com.research.rest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thomas on 03/10/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Tupleable<String> {
    private String name;
    private String surname;

    private List<Tuple<String>> tuples;
    private Iterator<Tuple<String>> tuplesIter;

    public Person() {
        //jackson...
    }

    public Person(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    @Override
    public String toString() {
        return new StringBuilder("name: ").append(name).append("\n")
                .append("surname: ").append(surname).append("\n").toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        addTuple("name", name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        addTuple("surname", surname);
    }

    private Person addTuple(String key, String value) {
        if (tuples == null) {
            tuples = new ArrayList<Tuple<String>>();
        }
        tuples.add(new Tuple<String>(key, value));
        return this;
    }


    @Override
    public Tuple<String> next() {
        if (tuplesIter == null) {
            if (tuples == null) {
                throw new RuntimeException("No tuples here, friend.");
            }
            tuplesIter = tuples.iterator();
        }
        return tuplesIter.next();
    }
}
