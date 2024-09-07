/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

import gr.codehub.eshoped.xmlmodeling.model.Department;
import gr.codehub.eshoped.xmlmodeling.model.Employee;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringWriter;



/**
 *
 * @author DimitrisIracleous
 */
public class ObjectToXMLConverter {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        Department department = new Department();
        String xmlString = convertObjectToXML(employee);
        System.out.println(xmlString);
    }

    // Method to convert object to XML string
    public static String convertObjectToXML(Employee person) 
            throws ParserConfigurationException, TransformerException {
        // Create a new DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new document
        Document document = builder.newDocument();

        // Create root element
        Element root = document.createElement("Person");
        document.appendChild(root);

        // Create child elements and append them to the root
        Element firstName = document.createElement("firstName");
        firstName.appendChild(document.createTextNode(person.getName()));
        root.appendChild(firstName);

        

        Element age = document.createElement("id");
        age.appendChild(document.createTextNode(String.valueOf(person.getId())));
        root.appendChild(age);

        // Transform the document to an XML string
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

        StringWriter writer = new StringWriter();
        DOMSource domSource = new DOMSource(document);
        StreamResult result = new StreamResult(writer);

        transformer.transform(domSource, result);

        return writer.toString();
    }
}

 