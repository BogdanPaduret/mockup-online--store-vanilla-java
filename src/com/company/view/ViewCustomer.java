package com.company.view;

import com.company.controllere.*;
import com.company.modele.*;
import com.company.modele.users.Customer;

import java.util.Scanner;

public class ViewCustomer {

    //variabile
    private ControlOrder controlOrder;
    private ControlOrderDetails controlOrderDetails;
    private ControlProduct controlProduct;

    private Customer customer;

    private Scanner scanner;
    private boolean running;
    private int choice;

    private Order order;



    //constructor
    public ViewCustomer(Customer customer) {
        scanner = new Scanner(System.in);

        String pathRoot = "src/com/company/resources/";
        String ordersPath = pathRoot + "orders";
        String orderDetailsPath = pathRoot + "orderDetails";
        String productsPath = pathRoot + "products";

        controlOrder = new ControlOrder(ordersPath);
        controlProduct = new ControlProduct(productsPath);
        controlOrderDetails = new ControlOrderDetails(orderDetailsPath);

        this.customer = customer;

        order= new Order(controlOrder.newOrderId(),customer.getId(),0);

        controlOrder.addOrder(order);
    }

    public ViewCustomer() {
        this(new Customer(99, "Mail 1", "pwd 1", "Nume Prenume"));
    }


    //menu
    public void menu() {
        String text = "";

        String pre = "Apasati tasta ";
        String suf = " pentru a ";

        String[] conditii = {
                "vedea detaliile contului tau",
                "vedea produsele ",
                "adauga un articol in comanda",
                "vizualiza articolele din cos",
                "vedea detaliile unei comenzi trecute",
                "edita cosul",
        };

        for (int i = 0; i < conditii.length; i++) {
            text += pre + i + suf + conditii[i] + "\n";
        }

        System.out.println(text);
    }


    //play
    public void play() {
        running = true;
        choice = -1;

        while (running) {
            System.out.println("Esti inregistrat ca: " + customer.getFullName());

            menu();
            System.out.println("");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                default:
                    exit();
                    break;
                case 1:
                    controlProduct.showAllProducts();
                    break;
                case 2:
                    newOrder();
                    break;
                case 3:
                    showBasket(order.getId());
                    break;
                case 4:
                    showAdditionalOrder();
                    break;
                case 5:
                    editBasket();
                    break;
            }
        }
    }


    //cases
    public void exit() {
        System.out.println("Salvati comanda?");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlOrderDetails.save();
            controlOrder.save();
            System.out.println("Comanda a fost salvata cu numarul "+ order.getId());
        } else {
            System.out.println("Comanda nu a fost salvata");
        }
        running = false;
    }
    public void newOrder() {
        System.out.println("Introduceti numele produsului pe care doriti sa-l comandati");
        String productName = scanner.nextLine();
        System.out.println("Introduceti cantitatea de comandat");
        double qty = Double.parseDouble(scanner.nextLine());
        Product product = controlProduct.getProduct(productName);
        if (product != null && product.getStock() >= qty) {
            OrderDetails details= new OrderDetails(
                    controlOrderDetails.newOrderDetailsId(),
                    this.order.getId(),
                    product.getId(),
                    product.getPrice()*qty,
                    qty
            );
            controlOrderDetails.addOrderDetails(details);

            //todo adaugare produs in amount din order?

            System.out.println("Proudul a fost adaugat in cos");
        } else {
            System.out.println("Comanda invalida");
        }

    }
    public void showBasket(int orderId) {
        for (OrderDetails details:controlOrderDetails.getOrderDetailsList(orderId)) {

            Product product = controlProduct.getProduct(details.getProductId());

            String text = "";

            text += "#" + details.getId() + "\n";
            text += "Nume articol: " + product.getName() + "\n";
            text += "Pret/unitate: " + product.getPrice() + "\n";
            text += "Cantitate: " + details.getQty() + "\n";
            text += "Total: " + details.getPrice() + "\n";

            System.out.println(text);
        }

        System.out.println(controlOrderDetails.getTotal(orderId));
    }
    public void showAdditionalOrder() {
        System.out.println("Introduceti numarul comenzii");
        int orderId = Integer.parseInt(scanner.nextLine());

        showBasket(orderId);
    }

    public void editBasket() {
        System.out.println("Introduceti sub urmatoarea forma:\nNumarul produsului,produs/cantitate/stergere,noua valoare (daca exista)");
        String[] input = scanner.nextLine().split(",");

        int productId = Integer.parseInt(input[0]);
        String command = input[1];
        String replacement = "";
        if (input.length > 2) {
            replacement = input[2];
        }

        OrderDetails details = controlOrderDetails.getOrderDetails(productId);

        if (details != null) {

            switch (command) {
                default:
                    System.out.println("Comanda incorecta");
                    break;
                case "produs":
                    changeProduct(details,replacement);
                    break;
                case "cantitate":
                    changeQty(details,replacement);
                    break;
                case "stergere":
                    removeItem(details);
                    break;
            }
        } else {
            System.out.println("ID produs nu exista!");
        }
    }

    public void changeProduct(OrderDetails details,String replacement) {
        Product newProduct = controlProduct.getProduct(replacement);
        if (newProduct != null && newProduct.getStock() > details.getQty()) {
            //details.setProductId(newProduct.getId());
            controlOrderDetails.updateProductId(details.getId(), newProduct.getId());
            //details.setPrice(newProduct.getPrice() * details.getQty());
            controlOrderDetails.updatePrice(details.getId(), newProduct.getPrice()* details.getQty());
            System.out.println("Produsul a fost modificat");
        } else {
            System.out.println("Produsul nu exista sau cantitatea noului produs este insuficienta");
        }
    }
    public void changeQty(OrderDetails details, String replacement) {
        Product product = controlProduct.getProduct(details.getProductId());
        double qty = Integer.parseInt(replacement);
        if (qty < product.getStock()) {
            //details.setQty(qty);
            controlOrderDetails.updateQuantity(details.getId(),qty);
            //details.setPrice(product.getPrice() * qty);
            controlOrderDetails.updatePrice(details.getId(), product.getPrice() * details.getQty());
            System.out.println("Cantitatea a fost modificata");
        } else {
            System.out.println("Stoc insuficient");
        }
    }
    public void removeItem(OrderDetails details) {
        Product product = controlProduct.getProduct(details.getProductId());
        System.out.println("Sigur doriti sa stergeti produsul: " + product.getName() + "? (y/n)");
        char ans = scanner.nextLine().toLowerCase().charAt(0);
        if (ans == 'y') {
            controlOrderDetails.deleteOrderDetails(details);
        }
    }
}
