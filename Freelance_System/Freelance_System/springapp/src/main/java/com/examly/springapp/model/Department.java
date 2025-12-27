package com.examly.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique=true)
    private String departmentName;
    private String contactEmail;
    private String contactPhone;

    public Department(){}
    public Department(String departmentName,String contactEmail,String contactPhone){
        this.departmentName=departmentName;
        this.contactEmail=contactEmail;
        this.contactPhone=contactPhone;
    }
    public void setId(long id){
        this.id=id;
    }
    public long getId(){
        return id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    
    
}
