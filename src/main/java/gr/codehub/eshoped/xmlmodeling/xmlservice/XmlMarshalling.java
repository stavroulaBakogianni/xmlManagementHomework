/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.domain.Person;
import gr.codehub.eshoped.xmlmodeling.model.Human;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DimitrisIracleous
 */
public class XmlMarshalling {
    
    // Marshalling (Object to XML)
    public static void marshalling() throws JAXBException {
        Person person = new Person(1, "John Doe", 25);
        // Create JAXB Context
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
       // Create Marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // To make the XML output pretty
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Marshall the object to XML
        StringWriter sw = new StringWriter();
        marshaller.marshal(person, sw);

        // Print out the XML content
        String xmlContent = sw.toString();
        System.out.println(xmlContent);
} 
    // UnMarshalling ( XML to Object )
    public static void unMarshalling() throws JAXBException {
        String xml = """
                <person>
                    <id>1</id>
                    <name>John Doe</name>
                    <age>25</age>
                </person>
                """;

        // Create JAXB Context
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        // Create Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Unmarshal the XML back into an object
        StringReader reader = new StringReader(xml);
        Person person = (Person) unmarshaller.unmarshal(reader);

        // Print out the person object
        System.out.println(person);
    }
    
    /**
     * UnMarshalling ( XMLfile to Object )
     *         // Create JAXB Context
     * // Create Unmarshaller
     *         // Unmarshal the XML back into an object
     * @param <T>
     * @param xmlFilename
     * @param classtype
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException 
     */

    public static <T extends Object> T unMarshallingFromFile(String xmlFilename, Class<T> classtype) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(classtype); 
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileInputStream reader = new FileInputStream(new File(xmlFilename));
            T t = (T) unmarshaller.unmarshal(reader);
        return t;
        } catch (JAXBException ex) {
            Logger.getLogger(XmlMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    
    
    
    public static void main(String[] args) throws JAXBException {
        //marshalling();
        //unMarshalling();
        Human human = unMarshallingFromFile("xml/human.xml", Human.class);
        System.out.println("" + human.getAddress());
    }
    
}
