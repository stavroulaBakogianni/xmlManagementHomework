/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DimitrisIracleous
 */
@Setter
@Getter  
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fullName")
@XmlRootElement
public class Employee {
    private int id;
    private String fullName;
 //   @JsonIgnore
  //  @JsonBackReference
    private Department departmentName;
}
