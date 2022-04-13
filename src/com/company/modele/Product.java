package com.company.modele;

public class Product {

    //variabile
    private int id;
    private String name;
    private double price;
    private double stock;

    private String separator = "/";

    //constructori
    public Product(int id, String name, double price, double stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public Product(String input) {
        String[] param = input.split(separator);

        this.id = Integer.parseInt(param[0]);
        this.name = param[1];
        this.price = Double.parseDouble(param[2]);
        this.stock = Double.parseDouble(param[3]);
    }

    //get
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getStock() {
        return stock;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }

    //toString
    public String show() {
        String text = "";

        text += "ID: " + this.id + "\n";
        text += "Name: " + this.name + "\n";
        text += "Price: " + this.price + "\n";
        text += "Stock: " + this.stock;

        return text;
    }

    //save
    public String saveInfo() {
        return id + separator + name + separator + price + separator + stock;
    }


}
