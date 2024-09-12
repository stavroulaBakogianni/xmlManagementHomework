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
import gr.codehub.eshoped.xmlmodeling.domain.Person;
import gr.codehub.eshoped.xmlmodeling.domain.User;
import gr.codehub.eshoped.xmlmodeling.model.Human;

import java.io.File;
import java.io.IOException;

public class JacksonExample {

    public static void main(String[] args) {
        
//        String jsonFilename = "json/user.json";
//        User user = new User(); 
//        
//        writeExample(jsonFilename, user);
        
        Human human = readExample("json/human.json", Human.class);
         System.out.println(human.getAddress());
    }
    
    //serialization   marsalling
    public static boolean writeExample(String jsonFilename, Object jsonObject) {
        File jsonFile = new File(jsonFilename);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(jsonFile, jsonObject);
            return true;
        } catch (IOException ex) {
           return false;
        }
     }
    
    /**
     * Read the JSON file and map it to the Person class
     * deserialization  unmarsalling
     * @param <T>
     * @param jsonFilename
     * @param classType
     * @return 
     */
    public static <T extends Object> T readExample(String jsonFilename, Class<T> classType){
         File jsonFile = new File(jsonFilename);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonFile, classType);
         } catch (IOException e) {
            return null;
        }
    }
}
