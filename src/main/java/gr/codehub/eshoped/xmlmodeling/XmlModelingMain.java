/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gr.codehub.eshoped.xmlmodeling;

import gr.codehub.eshoped.xmlmodeling.model.Address;
import gr.codehub.eshoped.xmlmodeling.model.Person;
import gr.codehub.eshoped.xmlmodeling.xmlservice.JaxbXsdGenerator;
import gr.codehub.eshoped.xmlmodeling.xmlservice.XmlManagement;
import gr.codehub.eshoped.xmlmodeling.xmlservice.XmlManagementImpl;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public class XmlModelingMain {

    public static void main(String[] args) throws IOException {
     
        JaxbXsdGenerator.xsdGenerator();
    }
    
    
    public static void decoding(){
           System.out.println("Hello World!");
        
        List<Person> persons = new ArrayList<>();
        
        Person person = new Person();
        person.setName("Dimitris");
        person.setAge(20);
        person.setMainAddress(new Address());
        
        persons.add (person);
        
        String fileName = "persons.xml";


//        XmlManagement xmlManager = new XmlManagementImpl();
//        xmlManager.saveToXmlFile(persons, fileName);
        
        
        XMLEncoder encoder = null;
	try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            encoder.writeObject(persons);
            encoder.close();
	}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
	}
	
        List<Person> readlist=null;
        
        XMLDecoder decoder = null;
        try{
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
            readlist = (List<Person>) decoder.readObject();
            decoder.close();
	}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
	}
        
        System.out.println(readlist);
    }
}
