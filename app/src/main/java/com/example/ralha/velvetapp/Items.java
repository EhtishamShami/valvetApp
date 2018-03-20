package com.example.ralha.velvetapp;

import android.graphics.Bitmap;

/**
 * Created by rajwahalqurashi on 2018-03-04.
 */

public class Items {

    Bitmap image;
    String itemStory;
    String itemBrand;
    String itemTitle;
    String itemYear;
    String itemRetailPrice;
    String itemRentalPrice;
    String itemCategory;
    String itemColor;
    String itemSize;


    public Items() {

    }

    public Items(Bitmap image, String itemStory, String itemBrand, String itemTitle, String itemYear, String itemRetailPrice, String itemRentalPrice, String itemCategory, String itemColor, String itemSize) {
        this.itemStory = itemStory;
        this.itemBrand = itemBrand;
        this.itemTitle = itemTitle;
        this.itemYear = itemYear;
        this.itemRetailPrice = itemRetailPrice;
        this.itemRentalPrice = itemRentalPrice;
        this.itemCategory = itemCategory;
        this.itemColor = itemColor;
        this.itemSize = itemSize;
        this.image=image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getItemStory() {
        return itemStory;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemYear() {
        return itemYear;
    }

    public String getItemRetailPrice() {
        return itemRetailPrice;
    }

    public String getItemRentalPrice() {
        return itemRentalPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemColor() {
        return itemColor;
    }

    public String getItemSize() {
        return itemSize;
    }
}

