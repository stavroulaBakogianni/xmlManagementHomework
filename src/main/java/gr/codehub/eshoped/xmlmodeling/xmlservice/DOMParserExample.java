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
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**

DOM (Document Object Model) is another method for reading XML files in Java. 
Unlike SAX and StAX, DOM parses the entire XML document into memory as a tree structure, 
allowing random access to elements within the XML. However, 
it can be memory-intensive, making it suitable for small-to-medium-sized XML files.
* 
* Initialize DocumentBuilderFactory
* Create a DocumentBuilder instance
* Parse the XML file and load it into a DOM Document object
* Normalize the XML structure (optional but recommended)
* Get the root element
*/
public class DOMParserExample {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("xml/people.xml"));
          
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Get all <person> elements
            NodeList personList = document.getElementsByTagName("person");

            // Loop through each <person> element
            for (int i = 0; i < personList.getLength(); i++) {
                Node  personNode = personList.item(i);

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

       
    }
}
