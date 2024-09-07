/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

/**
 *
 * @author DimitrisIracleous
 */
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*

DOM (Document Object Model) is another method for reading XML files in Java. 
Unlike SAX and StAX, DOM parses the entire XML document into memory as a tree structure, 
allowing random access to elements within the XML. However, 
it can be memory-intensive, making it suitable for small-to-medium-sized XML files.

*/



public class DOMParserExample {

    public static void main(String[] args) {
        try {
            // Initialize DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and load it into a DOM Document object
            Document document = builder.parse(new File("people.xml"));

            // Normalize the XML structure (optional but recommended)
            document.getDocumentElement().normalize();

            // Get the root element
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Get all <person> elements
            NodeList personList = document.getElementsByTagName("person");

            // Loop through each <person> element
            for (int i = 0; i < personList.getLength(); i++) {
                Node personNode = personList.item(i);

                if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element personElement = (Element) personNode;

                    // Get the id attribute of the person element
                    String id = personElement.getAttribute("id");

                    // Get the name and age elements inside <person>
                    String name = personElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = personElement.getElementsByTagName("age").item(0).getTextContent();

                    // Print out the person details
                    System.out.println("Person ID: " + id + ", Name: " + name + ", Age: " + age);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
