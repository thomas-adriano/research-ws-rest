package br.com.research.rest;

/**
 * Created by Thomas on 04/10/2014.
 */
public class Tuple<T> {

    private T key;
    private T element;

    public Tuple() {

    }

    public Tuple (T key, T element) {
        this.key = key;
        this.element = element;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
