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
import gr.codehub.eshoped.xmlmodeling.domain.Person;

import java.io.File;
import java.io.IOException;

public class JacksonExample {

    public static void main(String[] args) {
        // Path to the JSON file
        File jsonFile = new File("person.json");

        
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
