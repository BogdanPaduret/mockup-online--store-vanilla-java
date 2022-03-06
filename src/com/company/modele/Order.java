package com.company.modele;

public class Order {

    //variabile
    private int id;
    private int customerId;
    private double amount;

    private String separator = "/";


    //constructori
    public Order(int id, int customerId, double amount) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
    }
    public Order(String input) {
        String[] param = input.split(separator);

        this.id = Integer.parseInt(param[0]);
        this.customerId = Integer.parseInt(param[1]);
        this.amount = Double.parseDouble(param[2]);

    }

    //get
    public int getId() {
        return id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public double getAmount() {
        return amount;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    //show
    public String showInfo() {
        String text = "";

        text += "ID: " + this.id + "\n";
        text += "Customer: " + this.customerId + "\n";
        text += "Amount: " + this.amount;

        return text;
    }

    //save
    public String saveInfo() {
        return this.id + separator + this.customerId + separator + this.amount;
    }


}
