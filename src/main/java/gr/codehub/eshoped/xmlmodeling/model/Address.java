/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author DimitrisIracleous
 */

@Data
public class Address implements Serializable{
    private String street;
    private String number;
    private String city;
}
