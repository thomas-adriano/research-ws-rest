
package br.com.research.wsxml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.research.wsxml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IncludePersonResponse_QNAME = new QName("http://wsxml.research.com.br/", "includePersonResponse");
    private final static QName _IncludePerson_QNAME = new QName("http://wsxml.research.com.br/", "includePerson");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.research.wsxml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link br.com.research.wsxml.IncludePersonResponse }
     * 
     */
    public IncludePersonResponse createIncludePersonResponse() {
        return new IncludePersonResponse();
    }

    /**
     * Create an instance of {@link br.com.research.wsxml.IncludePerson }
     * 
     */
    public IncludePerson createIncludePerson() {
        return new IncludePerson();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link br.com.research.wsxml.IncludePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsxml.research.com.br/", name = "includePersonResponse")
    public JAXBElement<IncludePersonResponse> createIncludePersonResponse(IncludePersonResponse value) {
        return new JAXBElement<IncludePersonResponse>(_IncludePersonResponse_QNAME, IncludePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link br.com.research.wsxml.IncludePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsxml.research.com.br/", name = "includePerson")
    public JAXBElement<IncludePerson> createIncludePerson(IncludePerson value) {
        return new JAXBElement<IncludePerson>(_IncludePerson_QNAME, IncludePerson.class, null, value);
    }

}
