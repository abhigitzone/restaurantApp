package com.example.restaurantapp.Data;

public class NorthData {
    String northTitle;
    String northDesc;
    String price;
    int northImg;

    public NorthData(String northTitle, String northDesc, String price, int northImg) {
        this.northTitle = northTitle;
        this.northDesc = northDesc;
        this.price = price;
        this.northImg = northImg;
    }

    public String getNorthTitle() {
        return northTitle;
    }

    public String getNorthDesc() {
        return northDesc;
    }

    public String getPrice() {
        return price;
    }

    public int getNorthImg() {
        return northImg;
    }
}
