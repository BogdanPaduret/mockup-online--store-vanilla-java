package com.company.controllere;

import com.company.modele.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOrderDetails {

    //variabile
    private ArrayList<OrderDetails> orderDetailsList;
    private String path;

    private String separator;


    //constructori
    public ControlOrderDetails(String path) {
        this.path = path;
        this.separator = "/";
        this.orderDetailsList = new ArrayList<>();
        load();
    }


    //create
    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
    }

    public int newOrderDetailsId() {
        if (orderDetailsList.size() == 0) {
            return 0;
        }
        return (orderDetailsList.get(orderDetailsList.size() - 1).getId() + 1);
    }


    //read
    public void load() {
        try {
            orderDetailsList.clear();
            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != "") {
                    orderDetailsList.add(new OrderDetails(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllOrderDetails() {
        for (OrderDetails orderDetails : orderDetailsList) {
            System.out.println(orderDetails.show() + "\n");
        }
    }

    public OrderDetails getOrderDetails(int id) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                return orderDetails;
            }
        }
        return null;
    }

    public int size() {
        int c = 0;
        for (OrderDetails orderDetails : orderDetailsList) {
            c++;
        }
        return c;
    }

    public boolean exists(int id) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public double getTotal(int orderId) {
        double total = 0;
        for (OrderDetails details : getOrderDetailsList(orderId)) {
            total += details.getPrice();
        }
        return total;
    }

    public ArrayList<OrderDetails> getOrderDetailsList(int orderId) {
        ArrayList<OrderDetails> basket = new ArrayList<>();
        for (OrderDetails details : orderDetailsList) {
            if (details.getOrderId() == orderId) {
                basket.add(details);
            }
        }
        return basket;
    }

    public int mostProduct() {
        return -1;
    }

    public int[] topProducts(int size) {
        return new int[]{-1};
    }


    //update
    public void updateOrderId(int id, int orderId) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                orderDetails.setOrderId(orderId);
            }
        }
    }

    public void updateProductId(int id, int productId) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                orderDetails.setProductId(productId);
            }
        }
    }

    public void updatePrice(int id, double price) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                orderDetails.setPrice(price);
            }
        }
    }

    public void updateQuantity(int id, double qty) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                orderDetails.setQty(qty);
            }
        }
    }


    //delete
    public void deleteOrderDetails(OrderDetails orderDetails) {
        this.orderDetailsList.remove(orderDetails);
    }

    public void deleteOrderDetails(int id) {
        for (OrderDetails details : orderDetailsList) {
            if (details.getId() == id) {
                orderDetailsList.remove(details);
            }
        }
    }

    public void clearSession() {
        this.orderDetailsList.clear();
    }

    public void deleteAll() {
        clearSession();
        save();
    }


    //todo functie ce primeste ca parametru orderID
    // si returneaza o lista cu toate
    // orderDetails ce contine orderId


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
        for (OrderDetails orderDetails : orderDetailsList) {
            text += orderDetails.saveInfo() + "\n";
        }
        return text;
    }
}
