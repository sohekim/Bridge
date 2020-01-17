package com.example.finalproject;

public class User {

    public String name, bio, venmoID, email;
    public int numOrders;
    public String contact;

    public User(String email) {
        this.email = email;
    }

    public User(String name, String bio, String venmoID, String contact, int numOrders) {
        this.name = name;
        this.bio = bio;
        this.venmoID = venmoID;
        this.contact = contact;
        this.numOrders = numOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getVenmoID() {
        return venmoID;
    }

    public void setVenmoID(String venmoID) {
        this.venmoID = venmoID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }
}
