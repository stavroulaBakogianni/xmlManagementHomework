/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.jsonservice;

/**
 *
 * @author DimitrisIracleous
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import gr.codehub.eshoped.xmlmodeling.domain.Employee;
import gr.codehub.eshoped.xmlmodeling.domain.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JacksonExample {

    public static void main(String[] args) {
        try {
            writeExample();
        } catch (IOException ex) {
            Logger.getLogger(JacksonExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeExample() throws IOException{
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        File jsonFile = new File("json/mysample.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(jsonFile, employees);
     }
    
    public static void readExample(){
         // Path to the JSON file
        File jsonFile = new File("json/person.json");
       
        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file and map it to the Person class
            Person person = objectMapper.readValue(jsonFile, Person.class);

            // Output the Person object
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
