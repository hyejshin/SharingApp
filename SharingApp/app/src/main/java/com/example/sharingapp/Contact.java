package com.example.sharingapp;

import java.util.UUID;

public class Contact extends Observable{
    private String id;
    private String username;
    private String email;

    public Contact(String username, String email, String id) {
        this.username = username;
        this.email = email;

        if (id == null) {
            setId();
        } else {
            updateId(id);
        }
    }

    public void updateId(String id){
        this.id = id;
        notifyObservers();
    }

    public String getId(){
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
        notifyObservers();
    }

    public void setUsername(String username) {
        this.username = username;
        notifyObservers();
    }

    public void setEmail(String email) {
        this.email = email;
        notifyObservers();
    }
}
