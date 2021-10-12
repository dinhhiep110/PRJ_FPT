/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Duy Hiep
 */
public class Student {
    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private Department department;
    private ArrayList<StudentCertificate> certs = new ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, Date dob, boolean gender, Department department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.department = department;
    }

    public ArrayList<StudentCertificate> getCerts() {
        return certs;
    }

    public void setCerts(ArrayList<StudentCertificate> certs) {
        this.certs = certs;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
}
