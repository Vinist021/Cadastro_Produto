package com.abutua.product_backend.models;

public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category;
    private boolean promotion;
    private boolean release;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public boolean isPromotion() {
        return promotion;
    }
    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
    public boolean isRelease() {
        return release;
    }
    public void setRelease(boolean release) {
        this.release = release;
    }
    
    //Métodos Construtores
    public Product(int id, String name, String description, double price, int category, boolean promotion, boolean release) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.promotion = promotion;
        this.release = release;
    }

    public Product() {
        
    }
}
