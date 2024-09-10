/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

/**
 *
 * @author DimitrisIracleous
 */
 



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.OutputKeys;

public class DomCreateXml {

    public static void main(String[] args) {

        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a DocumentBuilder
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            // Step 3: Create a Document
            Document document = documentBuilder.newDocument();

            // Step 4: Create root element
            Element root = document.createElement("Company");
            document.appendChild(root);

            // Step 5: Create child elements
            Element employee = document.createElement("Employee");
            root.appendChild(employee);

            // Step 6: Add child element details
            Element firstName = document.createElement("FirstName");
            firstName.appendChild(document.createTextNode("John"));
            employee.appendChild(firstName);

            Element lastName = document.createElement("LastName");
            lastName.appendChild(document.createTextNode("Doe"));
            employee.appendChild(lastName);

            Element department = document.createElement("Department");
            department.appendChild(document.createTextNode("Engineering"));
            employee.appendChild(department);

            // Step 7: Create a Transformer to write the document to an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            
               // Enable beautifier (pretty printing)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Set indent spacing

            
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("xml\\company-employees.xml"));

            // Step 8: Write the document to file
            transformer.transform(domSource, streamResult);

            System.out.println("XML file created successfully.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
