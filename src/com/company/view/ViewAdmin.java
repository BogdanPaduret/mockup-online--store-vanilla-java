package com.company.view;

import com.company.controllere.*;
import com.company.modele.*;
import com.sun.source.tree.PackageTree;

import java.util.Scanner;

public class ViewAdmin {

    //variabile
    private ControlOrder controlOrder;
    private ControlOrderDetails controlOrderDetails;
    private ControlProduct controlProduct;
    private ControlCustomer controlCustomer;

    private Customer customer;
    private Order order;

    private Scanner scanner;

    private boolean running;
    private int choice;

    //constructor
    public ViewAdmin(Customer customer) {
        String rootPath = "src/com/company/resources/";
        String orderPath = rootPath + "orders";
        String orderDetailsPath = rootPath + "orderDetails";
        String productPath = rootPath + "products";
        String customerPath = rootPath + "customers";

        controlOrder = new ControlOrder(orderPath);
        controlOrderDetails = new ControlOrderDetails(orderDetailsPath);
        controlProduct = new ControlProduct(productPath);
        controlCustomer = new ControlCustomer(customerPath);

        this.customer = customer;
        order = new Order(controlOrder.newOrderId(), customer.getId(), 0);

        scanner = new Scanner(System.in);
    }
    public ViewAdmin() {
        this(new Customer(99, "mail 1", "123", "Firstname Lastname", true));

    }


    //menu
    private void menu() {
        String text = "";
        String pre = "Apasati ";
        String suf = " pentru a ";
        String[] act = {
                "vedea toti clientii",
                "adauga un client",
                "sterge un client",
                "modifica un produs",
                "vedea care este cel mai mare cumparator",
                "vedea care este cel mai popular produs",
                "vedea o lista a produselor si valoarea vanduta per produs sortate descrescator",
                "vedea o lista a top 10 cei mai mari cumparatori sortati descrescator si suma medie per comanda",
        };

        for (int i = 0; i < act.length; i++) {
            text += pre + i + suf + act[i] + "\n";
        }
        text += pre + "orice alt numar" + suf + "iesi";
        System.out.println(text);
    }


    //play
    public void play() {
        running = true;
        choice = -1;

        while (running) {
            System.out.println("Esti inregistrat ca: " + customer.getFullName());

            menu();

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                default:
                    exit();
                    break;
                case 0:
                    controlCustomer.showCustomers();
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    mostPopularCustomer();
                    break;
                case 5:
                    mostPopularProduct();
                    break;
                case 6:
                    top10Customers();
                    break;
                case 7:
                    top10Products();
                    break;
            }
        }
    }


    //cases
    private void exit() {
        System.out.println("Salvati inainte de a iesi?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlCustomer.save();
            controlProduct.save();
            controlOrder.save();
            controlOrderDetails.save();
            System.out.println("Modificarile au fost salvate");
        } else {
            System.out.println("Modificarile nu au fost salvate");
        }
        running = false;
    }
    private void addCustomer() {
        System.out.println("Introduceti NUMELE, EMAIL-ul,PAROLA si daca este ADMINISTRATOR despartite prin virgula");
        String[] input = scanner.nextLine().split(",");

        String fullName = input[0];
        String email = input[1];
        String pwd = input[2];
        boolean admin = Boolean.parseBoolean(input[3]);

        controlCustomer.addCustomer(new Customer(controlCustomer.newCustomerId(), email, pwd, fullName, admin));
        System.out.println("Clientul a fost adaugat");
    }
    private void removeCustomer() {
        System.out.println("Introduceti NUMELE si EMAIL-ul clientului ce trebuie sters");
        String[] input = scanner.nextLine().split(",");

        String fullName = input[0];
        String email = input[1];

        Customer customer = controlCustomer.getCustomer(email, fullName);
        if (customer != null) {
            controlCustomer.deleteCustomer(controlCustomer.getCustomer(email, fullName));
            System.out.println("Client sters");
        } else {
            System.out.println("Clientul nu exista");
        }

    }
    private void editProduct() {
        System.out.println("Introduceti sub urmatoare forma detaliile editarii:\n" +
                "(ID Produs daca este cazul)\n" +

                "(actiune: " +
                "add-adaugare produs nou, nu este nevoie de ID" +
                "del-stergere/" +
                "nume-modificare nume/" +
                "cant-modificare cantitate/" +
                "pret-modificare pret)\n" +

                "(valoarea cu care se face inlocuirea daca este cazul)\n\n" +

                "Detaliile se scriu intr-un singur rand despartite prin virgula");

        String[] input = scanner.nextLine().split(",");

        int id = -1;
        String act = "";
        String replace = "";

        if (isNumber(input[0]) == true) {

            if (input.length >= 2) {

                id = Integer.parseInt(input[0]);
                act = input[1];

                if (input.length == 3) {
                    replace = input[2];
                }

                Product product = controlProduct.getProduct(id);

                if (product != null) {

                    switch (act) {
                        default:
                            System.out.println("Actiune invalida");
                            break;
                        case "del":
                            deleteProduct(product);
                            break;
                        case "nume":
                            renameProduct(product, replace);
                            break;
                        case "cant":
                            changeQuantity(product, Double.parseDouble(replace));
                            break;
                        case "pret":
                            changePrice(product, Double.parseDouble(replace));
                            break;
                    }
                }
            }
        } else {
            addProduct();
        }

    }

    private void mostPopularCustomer() {

    }

    private void mostPopularProduct() {

    }

    private void top10Customers() {

    }

    private void top10Products() {

    }

    //metode editProduct
    private boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private void deleteProduct(Product product) {
        System.out.println("Sigur stergeti produsul?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlProduct.deleteProduct(product);
            System.out.println("Produs sters");
        } else {
            System.out.println("Operatie abandonata");
        }
    }
    private void renameProduct(Product product, String name) {
        System.out.println("Sigur doriti sa redenumiti '" + product.getName() + "' in '" + name + "'?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlProduct.updateName(product.getId(), name);
            System.out.println("Produs redenumit");
        } else {
            System.out.println("Anulat");
        }
    }
    private void changeQuantity(Product product, double qty) {
        System.out.println("Sigur doriti sa schimbati cantitatea produsului '" + product.getName() + "' din " +
                product.getStock() + " in " + Math.floor(qty * 100) / 100 + "?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlProduct.updateStock(product.getId(), qty);
            System.out.println("Stocul a fost schimbat");
        } else {
            System.out.println("Anulat");
        }
    }
    private void changePrice(Product product, double price) {
        System.out.println("Sigur doriti sa schimbat pretul a '" + product.getName() + "' din " + product.getPrice() +
                " in " + Math.floor(price * 100) / 100 + "?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlProduct.updatePrice(product.getId(), price);
            System.out.println("Pretul a fost schimbat");
        } else {
            System.out.println("Anulat");
        }
    }
    private void addProduct() {
        System.out.println("Introduceti: ID/nume/pret/stock");
        controlProduct.addProduct(new Product(scanner.nextLine()));
        System.out.println("Produs adaugat");
    }




}
