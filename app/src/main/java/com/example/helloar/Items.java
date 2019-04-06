package com.example.helloar;

public class Items {
    private int itemNo;
    private String itemName;
    private String sfbFile;
    private double itemPrice;

    public Items(int itemNo, String itemName, double itemPrice, String sfbFile){
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.sfbFile = sfbFile;
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
}
