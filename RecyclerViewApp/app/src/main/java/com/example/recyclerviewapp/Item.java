package com.example.recyclerviewapp;

public class Item {
    int itemImage;
    String itemTitle;
    String itemDesc;

    public Item(int itemImage, String itemTitle, String itemDesc) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
        this.itemDesc = itemDesc;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
