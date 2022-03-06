package com.company.modele;

public class OrderDetails {

    //variabile
    private int id;
    private int orderId;
    private int productId;
    private double price;
    private double qty;

    private String separator = "/";

    //constructori
    public OrderDetails(int id, int orderId, int productId, double price, double qty) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.qty = qty;
    }
    public OrderDetails(String input) {
        String[] p = input.split(separator);

        this.id = Integer.parseInt(p[0]);
        this.orderId = Integer.parseInt(p[1]);
        this.productId = Integer.parseInt(p[2]);
        this.price = Double.parseDouble(p[3]);
        this.qty = Double.parseDouble(p[4]);
    }

    //get
    public int getId() {
        return id;
    }
    public int getOrderId() {
        return orderId;
    }
    public int getProductId() {
        return productId;
    }
    public double getPrice() {
        return price;
    }
    public double getQty() {
        return qty;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQty(double qty) {
        this.qty = qty;
    }

    //show
    public String show() {
        String text = "";

        text += "ID: " + this.id + "\n";
        text += "Order ID: " + this.orderId + "\n";
        text += "Product ID: " + this.productId + "\n";
        text += "Price: " + this.price + "\n";
        text += "Quantity: " + this.qty;

        return text;
    }

    //save
    public String saveInfo() {
        return this.id + separator + this.orderId + separator + this.productId + separator + this.price + separator + this.qty;
    }

}
