/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.service;

import gr.codehub.eshoped.xmlmodeling.model.Address;
import gr.codehub.eshoped.xmlmodeling.model.Person;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public class XmlManagementImpl implements XmlManagement{

    @Override
    public void saveToXmlFile(List<Person> persons, String xmlFilenmae) throws IOException {
        
 
        PrintWriter printer = new PrintWriter(new File(xmlFilenmae));
        printer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>");
        printer.println("<persons>");
        for (Person person : persons){
            printer.println("<person>");
                printer.println("<name>"+person.getName()+"</name>");
                printer.println("<age>"+person.getAge()+"</age>");
                printer.println("<doc>"+person.getDoc()+"</doc>");
               if ( person.getMainAddress()!= null)
                printer.println("<mainAddress street= \""
                        +person.getMainAddress().getStreet()
                        +"\"  number= \""+person.getMainAddress().getNumber()
                        +"\" ></mainAddress>");
                
              
                printer.println("<otherAddresses>");
                if ( person.getOtherAddresses()!= null)
                for (Address address : person.getOtherAddresses()){
                      printer.println("<otherAddress"
                        + " street= \""    +address.getStreet()
                        +"\"  number= \""+address.getNumber()
                        +"\" ></otherAddress>");
                }
                printer.println("</otherAddresses>");
            printer.println("</person>");    
        }
         printer.println("</persons>");
         printer.close();
    }
    
}
