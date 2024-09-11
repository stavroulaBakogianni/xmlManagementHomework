/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.codehub.eshoped.xmlmodeling.domain.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

/**
 *
 * @author DimitrisIracleous
 */
public class Converters {
    
    
    public static void main(String[] args) {
        jsonToXml("json\\person.json","xml\\new.xml");
    }
    
    
    public static void jsonToXml(String jsonFileName, String xmlFileName){
        savePersonToXml( readPersonFromJson(jsonFileName) , xmlFileName);
    }
     
    public static Person readPersonFromJson(String jsonFileName){
        File jsonFile = new File(jsonFileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Person person = objectMapper.readValue(jsonFile, Person.class);
            return person;
        } catch (IOException e) {
            return null;
        }
    }
      
    public static void savePersonToXml(Person person, String xmlFileName ) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Marshall the object to XML
            PrintWriter sw = new PrintWriter(new File(xmlFileName));
            marshaller.marshal(person, sw);
        }
        catch(JAXBException | FileNotFoundException e){
            
        }
    }
}
