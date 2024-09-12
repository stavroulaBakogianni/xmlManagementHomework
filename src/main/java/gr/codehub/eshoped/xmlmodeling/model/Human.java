/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DimitrisIracleous
 */
//@XmlRootElement(name = "human")
//@XmlType(propOrder = {  "name", "age","address" })
//public record Human(String name, int age, String address) {}

@Getter
@Setter
@XmlRootElement(name = "human")
@XmlType(propOrder = {  "name", "age","address" })
public class Human{
    private String name;
    private int age;
    private String address;
}