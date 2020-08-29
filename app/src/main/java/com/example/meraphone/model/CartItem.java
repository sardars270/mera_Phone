package com.example.meraphone.model;

public class CartItem {

    String Id;
    String productid;
    String userid;
    String bookingdt;
    String imageName;
    String ItemName;
    String Price;
    String status;

    public CartItem() {
    }

    public CartItem(String id, String productid, String userid, String bookingdt, String imageName, String itemName, String price, String status) {
        this.Id = id;
        this.productid = productid;
        this.userid = userid;
        this.bookingdt = bookingdt;
        this.imageName = imageName;
        ItemName = itemName;
        Price = price;
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookingdt() {
        return bookingdt;
    }

    public void setBookingdt(String bookingdt) {
        this.bookingdt = bookingdt;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


