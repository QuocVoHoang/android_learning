package com.andro.andro01.recyclerview;

public class Item {
    int itemImg;
    String itemTitle, itemDes;

    public Item(int itemImg, String itemTitle, String itemDes) {
        this.itemImg = itemImg;
        this.itemTitle = itemTitle;
        this.itemDes = itemDes;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDes() {
        return itemDes;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }
}
