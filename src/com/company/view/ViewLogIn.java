package com.company.view;

import com.company.controllere.*;
import com.company.modele.*;

import java.util.Scanner;

public class ViewLogIn {

    //variabile
    private ControlCustomer controlCustomer;
    private ControlOrder controlOrder;

    private Customer customer;

    private Scanner scanner;
    private boolean running;
    private int choice;


    //constructor
    public ViewLogIn() {
        String pathRoot = "src/com/company/resources/";
        String customersPath = pathRoot + "customers";
        String ordersPath = pathRoot + "orders";

        controlCustomer = new ControlCustomer(customersPath);
        controlOrder = new ControlOrder(ordersPath);

//        customer = new Customer("1/Mail 1/PWD 1/FirstName LastName");

        scanner = new Scanner(System.in);
    }


    //menu
    private void menu() {
        String text = "";
        String pre = "Apasati ";
        String suf = " pentru a ";
        String[] act = {
                "inregistra",
                "loga",
        };
        for (int i = 0; i < act.length; i++) {
            text += pre + i + suf + act[i] + "\n";
        }
        text += pre + "orice alta tasta" + suf + "iesi";

        System.out.println(text);
    }


    //play
    public void play() {
        running = true;
        choice = -1;

        while (running) {
            menu();

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                default:
                    //exit
                    exit();
                    break;
                case 0:
                    //register
                    register();
                    break;
                case 1:
                    //login
                    login();
                    break;
            }
        }
    }

    private void exit() {
        System.out.println("Salvati inainte de a iesi?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            System.out.println("Modificarile au fost salvate");
            controlOrder.save();
            controlCustomer.save();
        } else {
            System.out.println("Modificarile NU au fost salvate");
        }
        running = false;
    }

    private void register() {
        System.out.println("Treceti EMAIL-ul, PAROLA si NUMELE INTREG despartite prin virgula");
        String[] input = scanner.nextLine().split(",");

        String email = input[0];
        String pwd = input[1];
        String fullName = input[2];

        controlCustomer.addCustomer(new Customer(controlCustomer.newCustomerId(), email, pwd, fullName));
    }

    private void login() {
        System.out.println("Introduceti numele intreg, adresa de email si apoi parola (despartite prin virgula)");
        String[] input = scanner.nextLine().split(",");

        String fullName = input[0];
        String email = input[1];
        String pwd = input[2];

        if (controlCustomer.existsCustomer(email, fullName)) {
            customer = controlCustomer.getCustomer(email, fullName);
            if (customer.getPassword().equals(pwd)) {
//                ViewCustomer(customer);
            } else {

            }
        }
    }

asdsadasdasdas
}
