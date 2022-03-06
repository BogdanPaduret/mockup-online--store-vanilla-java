package com.company.modele;

public class Customer {

    //variabile
    private int id;
    private String email;
    private String password;
    private String fullName;

    private String separator = "/";

    //constructori
    public Customer(int id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
    public Customer(String input) {
        String[] param = input.split(separator);
        this.id = Integer.parseInt(param[0]);
        this.email = param[1];
        this.password = param[2];
        this.fullName = param[3];
    }

    //get
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFullName() {
        return fullName;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //show
    public String show() {
        String text = "";

        text += "ID: " + this.id + "\n";
        text += "Email: " + this.email + "\n";
        text += "Name: " + this.fullName;

        return text;
    }

    //save
    public String saveInfo() {
        return this.id + separator + this.email + separator + this.password + separator + this.fullName;
    }

}
