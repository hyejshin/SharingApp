package com.example.sharingapp;


public class ContactController extends Observable {

    Contact contact;

    public ContactController(Contact contact) {
        this.contact = contact;
    }

    public void updateId(String id){
        contact.updateId(id);
    }

    public String getId(){
        return contact.getId();
    }

    public String getUsername() {
        return contact.getUsername();
    }

    public String getEmail() {
        return contact.getEmail();
    }

    public void setId() {
        contact.setId();
    }

    public void setUsername(String username) {
        contact.setUsername(username);
    }

    public void setEmail(String email) {
        contact.setEmail(email);
    }

    public void addObserver(Observer observer) {
        contact.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contact.removeObserver(observer);
    }
}
