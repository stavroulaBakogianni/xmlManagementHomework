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
import gr.codehub.eshoped.xmlmodeling.model.Department;
import gr.codehub.eshoped.xmlmodeling.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JacksonExample {

    public static void main(String[] args) {
        
        String jsonFilename = "json/department.json";
        Department department = new Department();
        department.setId(10);
        department.setName("Sales");
        Employee employee = new Employee();
        department.setEmployees(new ArrayList<>());
        department.getEmployees().add(employee);
        employee.setId(7);
        employee.setFullName("George");
        employee.setDepartmentName(department);
        
        
        writeExample(jsonFilename, department);
   
        
   //     Human human = readExample("json/human.json", Human.class);
    //     System.out.println(human.getAddress());
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
