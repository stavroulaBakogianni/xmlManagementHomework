/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.domain.Person;
import gr.codehub.eshoped.xmlmodeling.domain.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

/**
 *
 * @author DimitrisIracleous
 */
@Slf4j
public class JaxbXmlValidation {
    public static void main(String[] args) {
     boolean validity = xmlValidator("xml/person-2.xml" ,  "xml/person-schema.xsd", Person.class);
     
     if (validity)
            System.out.println("The file is valid");
     else
            System.out.println("Yhe file is not valid");
    
    }
   
 // 
  /**
   * Create JAXB context for the Person class, Create Unmarshaller
   * Create SchemaFactory for loading the XSD, Load the XSD file (ensure the correct path to the XSD file)
   * Set schema to the unmarshaller (for validation)
   * Validate and Unmarshal XML to a Person object
   * @param xmlFileName
   * @param xsdFileame
   * @return 
   */  
    public static boolean xmlValidator(String xmlFileName, String xsdFileame, Class xmlClass) {
        log.debug("method starts");
        boolean returnStatus = false;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFileame));
            unmarshaller.setSchema(schema);
            File xmlFile = new File(xmlFileName);
            Object object = unmarshaller.unmarshal(xmlFile);
            log.debug("xml validated ", object);
            returnStatus = true;
       } catch (JAXBException | SAXException e) {
           log.debug("not valid xml", e);
        } 
         log.debug("method terminates");
         return returnStatus;
    }
}
