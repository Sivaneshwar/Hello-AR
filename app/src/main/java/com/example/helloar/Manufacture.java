package com.example.helloar;

import java.util.ArrayList;

public class Manufacture {
    int ID;
    double rating;
    String address;
    ArrayList<Items> products;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Items item){
        products.add((item));
    }

    public Items getProduct (int itemNo){
        return products.get(itemNo);
    }
}
