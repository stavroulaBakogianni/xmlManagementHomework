/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.model;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author DimitrisIracleous
 */
@Data
public class Person  {
    private String name;
    private int age;
    private String doc;
    private Address mainAddress;
    private List<Address> otherAddresses;
}
