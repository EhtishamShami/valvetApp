package com.example.ralha.velvetapp.model;

/**
 * @author Rafae Malik Ishtiaq on 3/19/2018.
 */

public class ItemModel {

    private String itemName = "";
    private String size = "";

    private String puchasePrice = "";
    private String retailPrice = "";
    private String brand = "";
    private String yearPurchased = "";
    private String category = "";
    private String color = "";

    public ItemModel(String itemName, String size, String puchasePrice, String retailPrice) {
        this.itemName = itemName;
        this.size = size;
        this.puchasePrice = puchasePrice;
        this.retailPrice = retailPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(String yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemModel(String itemName, String size, String puchasePrice, String retailPrice, String brand, String yearPurchased, String category, String color) {
        this.itemName = itemName;
        this.size = size;
        this.puchasePrice = puchasePrice;
        this.retailPrice = retailPrice;
        this.brand = brand;
        this.yearPurchased = yearPurchased;
        this.category = category;
        this.color = color;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPuchasePrice() {
        return puchasePrice;
    }

    public void setPuchasePrice(String puchasePrice) {
        this.puchasePrice = puchasePrice;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }
}
