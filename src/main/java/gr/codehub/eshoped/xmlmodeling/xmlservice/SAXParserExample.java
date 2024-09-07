/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.xmlservice;

/**
 *
 * @author DimitrisIracleous
 */
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*

The SAX (Simple API for XML) parser is another great option for reading 
large XML files incrementally in Java. SAX is an event-driven parser, 
meaning it reads the XML document sequentially and triggers events 
when it encounters start elements, end elements, and text data. 
It’s memory efficient because it doesn’t load the entire XML document into memory.


*/


public class SAXParserExample {

    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory instance
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Create a SAXParser instance
            SAXParser saxParser = factory.newSAXParser();

            // Create an instance of our custom handler
            PersonHandler handler = new PersonHandler();

            // Parse the XML file
            saxParser.parse("people.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Custom SAX Handler to process the XML data
class PersonHandler extends DefaultHandler {

    private String currentElement = "";
    private String id = null;
    private String name = null;
    private String age = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Set the current element
        currentElement = qName;

        // If <person> element is encountered, get the "id" attribute
        if ("person".equals(currentElement)) {
            id = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Capture the text content between the start and end tags
        if ("name".equals(currentElement)) {
            name = new String(ch, start, length);
        } else if ("age".equals(currentElement)) {
            age = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // When the </person> tag is encountered, print the information
        if ("person".equals(qName)) {
            System.out.println("Person ID: " + id + ", Name: " + name + ", Age: " + age);
            // Reset variables for the next <person> element
            id = name = age = null;
        }
        // Reset the current element when an end tag is encountered
        currentElement = "";
    }
}
