/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.xmlmodeling.domain;

/**
 *
 * @author DimitrisIracleous
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @JsonProperty("user_id")
    public int getId() {
        return id;
    }

    @JsonProperty("user_id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("full_name")
    public String getName() {
        return name;
    }

    @JsonProperty("full_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
