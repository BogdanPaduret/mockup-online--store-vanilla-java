package com.company.controllere;

import com.company.modele.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOrder {

    //variabile
    private ArrayList<Order> orders;
    private String path;

    private String separator;


    //constructori
    public ControlOrder(String path) {
        this.path = path;
        this.separator = "/";
        this.orders = new ArrayList<>();
        load();
    }


    //create
    public void addOrder(Order order) {
        this.orders.add(order);
    }
    public int newOrderId() {
        if (orders.size() == 0) {
            return 0;
        }
        return (orders.get(orders.size() - 1).getId() + 1);
    }


    //read
    public void load() {
        try {
            orders.clear();

            File file = new File(path);

            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                if (line != "") {
                    orders.add(new Order(line));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showOrders() {
        for (Order order : orders) {
            System.out.println(order.showInfo() + "\n");
        }
    }
    public Order getOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    public int size() {
        int c = 0;
        for (Order order : orders) {
            c++;
        }
        return c;
    }
    public boolean exists(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean exists(int customerId, Double amount) {
        for (Order order : orders) {
            if (order.getCustomerId() == customerId && order.getAmount() == amount) {
                return true;
            }
        }
        return false;
    }

//    public int mostCustomer() {
//
//        for (Order order : orders) {
//
//        }
//    }

    public int topCustomers(int size) {
        return -1;
    }

    public int[] customers() {
        int[] list = new int[0];
        for (Order order : orders) {
            int id = order.getCustomerId();
            if (existsInt(list, id) == false) {
                list = addToIntList(list, id);
            }
        }
        return list;
    }

    private int[] addToIntList(int[] list, int add) {
        int[] newList;

        if (list.length == 0) {
            newList = new int[]{add};
        } else {
            int size = list.length + 1;
            newList = new int[size];
            for (int i = 0; i < newList.length - 1; i++) {
                newList[i] = list[i];
            }
            newList[size-1] = add;
        }
        return newList;
    }

    private boolean existsInt(int[] list, int n) {
        if (list.length > 0) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == n) {
                    return true;
                }
            }
        }
        return false;
    }


    //update
    public void updateCustomerId(int id, int customerId) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setCustomerId(customerId);
            }
        }
    }
    public void updateAmount(int id, double amount) {
        for(Order order : orders){
             if(order.getId()==id){
                  order.setAmount(amount);
             }
        }
    }


    //delete
    public void deleteOrder(Order order) {
        this.orders.remove(order);
    }
    public void clearSession() {
        this.orders.clear();
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
        for (Order order : orders) {
            text += order.saveInfo() + "\n";
        }
        return text;
    }

}
