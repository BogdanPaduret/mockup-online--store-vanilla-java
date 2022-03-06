package com.company.controllere;

import com.company.modele.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlProduct {

    //variabile
    private ArrayList<Product> products;
    private String path;

    private String separator;


    //constructori
    public ControlProduct(String path) {
        this.path = path;
        this.separator = "/";
        this.products = new ArrayList<>();

        load();
    }


    //create
    public void addProduct(Product product) {
        this.products.add(product);
    }
    public int generateNewId() {
        if (products.size() == 0) {
            return 0;
        }
        return products.get(products.size() - 1).getId() + 1;
    }


    //read
    public void load() {
        try {
            products.clear();
            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != "") {
                    products.add(new Product(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product.show() + "\n");
        }
    }
    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(name.toLowerCase())) {
                return product;
            }
        }
        return null;
    }
    public int size() {
        int c = 0;
        for (Product product : products) {
            c++;
        }
        return c;
    }
    public boolean exits(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean exists(String name) {
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    //update
    public void updateName(int id, String name) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
            }
        }
    }
    public void updatePrice(int id, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(price);
            }
        }
    }
    public void updateStock(int id, double stock) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setStock(stock);
            }
        }
    }


    //delete
    public void deleteProduct(Product product) {
        products.remove(product);
    }
    public void clearSession() {
        products.clear();
    }
    public void deleteAll() {
        clearSession();
        save();
    }


    //save
    public void save() {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String toSave() {
        String text = "";
        for (Product product : products) {
            text += product.saveInfo() + "\n";
        }
        return text;
    }
}
