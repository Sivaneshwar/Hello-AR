package com.example.helloar;

public class Items {
    private int itemNo;
    private String itemName;
    private String sfbFile;
    private double itemPrice;
    private int itemImage;
    private String cardViewId;
    private String manufacture;
    private double rating;
    private String address;

    public Items(int itemNo, String itemName, double itemPrice, String sfbFile, int itemImage, String cardViewId){
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.sfbFile = sfbFile;
        this.itemImage = itemImage;
        this.cardViewId = cardViewId;
    }

    public Items(int itemNo, String itemName, double itemPrice, String sfbFile, int itemImage, String cardViewId, String manufacture, double rating, String address){
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.sfbFile = sfbFile;
        this.itemImage = itemImage;
        this.cardViewId = cardViewId;
        this.manufacture = manufacture;
        this.rating = rating;
        this.address = address;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSfbFile() {
        return sfbFile;
    }

    public void setSfbFile(String sfbFile) {
        this.sfbFile = sfbFile;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getCardViewId() {
        return cardViewId;
    }

    public void setCardViewId(String cardViewId) {
        this.cardViewId = cardViewId;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
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
}
