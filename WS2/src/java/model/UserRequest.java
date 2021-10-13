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
public class UserRequest {
    private int id;
    private String reason;
    private Date requestDate;
    private Account account;

    public UserRequest() {
    }

    public UserRequest(int id, String reason, Date requestDate, Account account) {
        this.id = id;
        this.reason = reason;
        this.requestDate = requestDate;
        this.account = account;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
    
   
}
