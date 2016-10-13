package com.thedeveloperworldisyours.fullrecycleview.swipe;

import java.io.Serializable;

/**
 * Created by javierg on 12/10/2016.
 */

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String emailId;

    public Employee() {

    }
    public Employee(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


}
