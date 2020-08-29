package com.example.shins.sharingapp;

import android.graphics.Bitmap;

public class Item {

    private String title;
    private String maker;
    private String description;
    private Dimensions dimensions;
    private String status;
    private String borrower;
    protected transient Bitmap image;
    protected String image_base64;
    private String id;
    private int icon;

    public Item(String title, String maker, String description, Dimensions dimension, Bitmap image, String id) {
        this.title = title;
        this.maker = maker;
        this.description = description;
        this.status = "Available";
        this.borrower = null;
        //addImage(image);
    }

    public Item(String title, String maker, String description, Dimensions dimension, String id) {
        this.title = title;
        this.maker = maker;
        this.description = description;
        this.status = "Available";
        this.borrower = null;
        //addImage(image);
    }

    public Item(int icon, String title, String maker, String description) {
        this.icon = icon;
        this.title = title;
        this.maker = maker;
        this.description = description;
        this.status = "Available";
        this.borrower = null;
        //addImage(image);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getTitle() {
        return title;
    }

    public String getMaker() {
        return maker;
    }

    public String getDescription() {
        return description;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getStatus() {
        return status;
    }

    public String getBorrower() {
        return borrower;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
