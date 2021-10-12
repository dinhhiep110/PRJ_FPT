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
public class Enrollment {
    private Date from;
    private Date to;
    private Course cid;
    private Employee eid;
    private boolean active;
    private String note;

    public Enrollment() {
    }

    public Enrollment(Date from, Date to, Course cid, Employee eid, boolean active, String note) {
        this.from = from;
        this.to = to;
        this.cid = cid;
        this.eid = eid;
        this.active = active;
        this.note = note;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Course getCid() {
        return cid;
    }

    public void setCid(Course cid) {
        this.cid = cid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
