/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.domain.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author DimitrisIracleous
 */
public class JaxbXsdGenerator {

    public static void xsdGenerator() throws IOException {
        try {
            // Create a JAXBContext for the class(es) you want to generate XSD for
            JAXBContext context = JAXBContext.newInstance(Person.class);

            // Use SchemaOutputResolver to generate the XSD schema
            context.generateSchema(new MySchemaOutputResolver());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // Custom implementation of SchemaOutputResolver to output the XSD file
    static class MySchemaOutputResolver extends SchemaOutputResolver {

        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
            // Specify the location and file where the XSD will be saved
            File file = new File("person-schema.xsd");

            // Create a StreamResult to write the schema to the file
            StreamResult result = new StreamResult(file);

            // Return the StreamResult with systemId set to file's absolute path
            result.setSystemId(file.toURI().toString());

            return result;
        }
    }
}
