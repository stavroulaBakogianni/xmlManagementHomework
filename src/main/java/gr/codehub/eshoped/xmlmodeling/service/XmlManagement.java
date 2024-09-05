/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.service;

import gr.codehub.eshoped.xmlmodeling.model.Person;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public interface XmlManagement {
    void saveToXmlFile(List<Person> persons, String xmlFilenmae) throws IOException;
}
