package com.nt.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String pass;

    @NotBlank
    private String phone;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String EMailId;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEMailId() {
        return EMailId;
    }

    public void setEMailId(String eMailId) {
        EMailId = eMailId;
    }

    @Override
    public String toString() {
        return "employee [id=" + id + ", name=" + name + ", pass=" + pass + ", phone=" + phone + ", EMailId=" + EMailId + "]";
    }
}
