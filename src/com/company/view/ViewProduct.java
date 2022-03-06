package com.company.view;

import com.company.controllere.ControlProduct;
import com.company.modele.Product;

import java.util.Scanner;

public class ViewProduct {

    //variabile
    private ControlProduct controlProduct;
    private Product product;

    private Scanner scanner;
    private boolean running;
    private int choice;


    //constructor
    public ViewProduct() {
        scanner = new Scanner(System.in);

        String pathRoot = "src/com/company/resources/";
        String ordersPath = pathRoot + "";
    }



}
