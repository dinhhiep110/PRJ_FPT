/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Duy Hiep
 */
public class Department {
    private int did;
    private String dname;
    private ArrayList<Student> arr = new ArrayList<>();
    
    public Department(){
        
    }

    public Department(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public ArrayList<Student> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Student> arr) {
        this.arr = arr;
    }

    
   
    
    
}
