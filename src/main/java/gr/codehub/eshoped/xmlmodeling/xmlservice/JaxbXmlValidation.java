/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.domain.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author DimitrisIracleous
 */
public class JaxbXmlValidation {
    public static void main(String[] args) {
        xmlValidator("person-2.xml" ,  "person-schema.xsd");
    }
   
 // 
    
    public static void xmlValidator(String xmlFileName, String xsdFileame) {
        try {
            // Create JAXB context for the Person class
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            // Create Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Create SchemaFactory for loading the XSD
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Load the XSD file (ensure the correct path to the XSD file)
            Schema schema = schemaFactory.newSchema(new File(xsdFileame));

            // Set schema to the unmarshaller (for validation)
            unmarshaller.setSchema(schema);

            // Validate and Unmarshal XML to a Person object
            File xmlFile = new File(xmlFileName);
            Person person = (Person) unmarshaller.unmarshal(xmlFile);

            // If the XML is valid, the following line will be executed
            System.out.println("XML is valid. Unmarshalled object: " + person);

        } catch (JAXBException | SAXException e) {
            // This block will catch validation errors
            System.err.println("Validation failed: " + e.getMessage());
        }
    }
    
    
    
}
