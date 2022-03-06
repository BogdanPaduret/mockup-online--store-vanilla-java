package com.company.controllere;

import com.company.modele.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCustomer {

    //variabile
    private ArrayList<Customer> customers;
    private String path;

    private String separator;


    //constructori
    public ControlCustomer(String path) {
        this.path = path;
        this.separator = "/";
        this.customers = new ArrayList<>();
        load();
    }

    //create
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }
    public int newCustomerId() {
        if (customers.size() == 0) {
            return 0;
        }
        return (customers.get(customers.size() - 1).getId() + 1);
    }

    //read
    public void load() {
        try {
            this.customers.clear();
            File file = new File(path);

            Scanner readFile = new Scanner(file);

            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                if (line != "") {
                    customers.add(new Customer(line));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.show() + "\n");
        }
    }
    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
    public Customer getCustomer(String email, String name) {
        for (Customer customer : customers) {
            if (customer.getEmail().toLowerCase().equals(email.toLowerCase()) && customer.getFullName().toLowerCase().equals(name.toLowerCase())) {
                return customer;
            }
        }
        return null;
    }
    public int size() {
        int c = 0;
        for (Customer customer : customers) {
            c++;
        }
        return c;
    }
    public boolean existsCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean existsCustomer(String email, String name) {
        for (Customer customer : customers) {
            if (customer.getEmail().toLowerCase().equals(email.toLowerCase()) && customer.getFullName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    //update
    public void updateEmail(int id, String email) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setEmail(email);
            }
        }
    }
    public void updatePassword(int id, String password) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setPassword(password);
            }
        }
    }
    public void updateName(int id, String fullName) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setFullName(fullName);
            }
        }
    }

    //delete
    public void deleteCustomer(Customer customer) {
        this.customers.remove(customer);
    }
    public void clearSession() {
        this.customers.clear();
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
    private String toSave() {
        String text = "";
        for (Customer customer : customers) {
            text += customer.saveInfo() + "\n";
        }
        return text;
    }

}
