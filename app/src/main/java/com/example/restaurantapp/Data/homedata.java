package com.example.restaurantapp.Data;

public class homedata {
    int image;
    String listName;

    public homedata(int image, String listName) {
        this.image = image;
        this.listName = listName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
