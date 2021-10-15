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
public class Account {
    private String username;
    private String password;
    private String displayName;
    private ArrayList<Feature> feature = new ArrayList<>();
    

    public Account() {
    }

    public Account(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public ArrayList<Feature> getFeature() {
        return feature;
    }

    public void setFeature(ArrayList<Feature> feature) {
        this.feature = feature;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    
}
