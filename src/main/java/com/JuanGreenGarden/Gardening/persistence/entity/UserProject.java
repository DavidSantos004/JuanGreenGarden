package com.JuanGreenGarden.Gardening.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserProject {
    
    @JsonIgnore
    private String user;

    @JsonIgnore
    private String pass;

    private String token;


    public UserProject() {
    }   

    public UserProject(String user, String pass, String token) {
        this.user = user;
        this.pass = pass;
        this.token = token;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            ", pass='" + getPass() + "'" +
            ", token='" + getToken() + "'" +
            "}";
    }
}
