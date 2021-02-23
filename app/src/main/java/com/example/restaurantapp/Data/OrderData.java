package com.example.restaurantapp.Data;

//This Modal data class is for order summary to show data in custom listView..
public class OrderData {
    String orderName;
    int quantity;
    int price;

    public OrderData(String orderName, int quantity, int price) {
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
