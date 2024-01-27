package com.example.firstspring.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private Long mobile;
    private String address;
    private String email;

    public Long getId() {
        return id;
    }

    public Long getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
