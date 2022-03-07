package com.company;

import com.company.controllere.ControlOrder;
import com.company.view.ViewCustomer;
import com.company.view.ViewLogIn;

public class Main {

    public static void main(String[] args) {

        ViewCustomer viewCustomer= new ViewCustomer();
        ViewLogIn viewLogIn = new ViewLogIn();

//        viewCustomer.play();
//        viewLogIn.play();
        ciorna();
    }

    public static void ciorna() {
        ControlOrder controlOrder = new ControlOrder("src/com/company/resources/orders");
        int[] a = controlOrder.customers();
        System.out.println(a.length);
        printList(a);
    }

    public static void printList(int[] arr) {
        String text = "";
        for (int i = 0; i < arr.length; i++) {
            text += arr[i] + " ";
        }
        System.out.println(text);
    }
}
