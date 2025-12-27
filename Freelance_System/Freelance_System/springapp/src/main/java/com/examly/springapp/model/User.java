package com.examly.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String username;
    private String email;
    private String role;
    private String phoneNumber;

    public User(){}

    public User(String username, String email, String role,String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber=phoneNumber;
        this.role = role;
    }
    
   public Long getUserId() {
    return userId;
   }

   public void setUserId(Long userId) {
    this.userId = userId;
   }

   public String getEmail() {
    return email;
   }

   public void setEmail(String email) {
    this.email = email;
   }

   public String getUsername() {
    return username;
   }

   public void setUsername(String username) {
    this.username = username;
   }

   public String getRole() {
    return role;
   }

   public void setRole(String role) {
    this.role = role;
   }

   public String getPhoneNumber() {
    return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
   }    
   

    
}
