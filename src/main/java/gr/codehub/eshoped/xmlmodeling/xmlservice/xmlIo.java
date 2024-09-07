/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.domain.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author DimitrisIracleous
 */
public class xmlIo {
    
    
    public static void main(String[] args) {
        writeXmlFile();
    }
    
    
    public static void readXmlFile(){
    try {
            // Create a JAXBContext for the Person class
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            // Create an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Unmarshal the XML into a Java object
            File xmlFile = new File("person.xml");
            Person person = (Person) unmarshaller.unmarshal(xmlFile);

            // Output the Java object data
            System.out.println("ID: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
         } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void writeXmlFile(){
    try {
            // Create the Person object
            Person person = new Person(123, "John Doe", 30);

            // Create JAXB context and initialize the Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // Make the XML output formatted
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Specify the XML output file
            File file = new File("person-3.xml");

            // Marshal the person object into the file
            jaxbMarshaller.marshal(person, file);

            // Also output to the console (optional)
            jaxbMarshaller.marshal(person, System.out);

            System.out.println("XML file created successfully!");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
}
