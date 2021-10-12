/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Duy Hiep
 */
public class Employee {
    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private String did;

    public Employee() {
    }

    public Employee(int id, String name, Date dob, boolean gender, String did) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.did = did;
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

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }
    
    
}
