/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.jsonservice;

/**
 *
 * @author DimitrisIracleous
 */
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class JsonSchemaValidatorExample {

    public static void main(String[] args) {
        try {
            
            /*
           String schemaString = """
                {
                  "$schema": "http://json-schema.org/draft-07/schema#",
                  "type": "object",
                  "properties": {
                    "name": {"type": "string"},
                    "age": {"type": "integer"},
                    "email": {"type": "string", "format": "email"}
                  },
                  "required": ["name", "age"]
                }
            """;

            InputStream schemaStream = new ByteArrayInputStream(schemaString.getBytes(StandardCharsets.UTF_8)); 
            */
            
            
            
            // Load JSON Schema from resource
        //    InputStream schemaStream = JsonSchemaValidatorExample.class.getResourceAsStream("/human-schema.json");
                InputStream schemaStream = new FileInputStream(new File("json/human-schema.json"));
            // Create a JsonSchemaFactory with the correct schema version (Draft-07)
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema schema = factory.getSchema(schemaStream);

            // JSON data to be validated
            String jsonData = """
                {
                  "name": "John Doe",
                  "age": 30,
                  "email": "john.doe@example.com"
                }
            """;

            // Convert JSON string to JsonNode
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonData);

            // Validate the JSON data against the schema
            Set<ValidationMessage> validationResult = schema.validate(jsonNode);

            // Check for validation errors
            if (validationResult.isEmpty()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON validation failed!");
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            }
        } catch (Exception e) {
            System.out.println("Error during validation: " + e.getMessage());
        }
    }
}
