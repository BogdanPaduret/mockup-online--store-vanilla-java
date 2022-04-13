package com.company.modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @BeforeEach
    public void init() {
        System.out.println("==========");
        System.out.println("Begin Test");
    }
    @AfterEach
    public void close() {

        System.out.println("End test");
        System.out.println("========");
    }


    //constructori
    @Test
    public void orderVarTest() {
        Order order = new Order(1, 2, 12.3);
        assertEquals(1, order.getId());
        assertEquals(2, order.getCustomerId());
        assertEquals(12.3, order.getAmount());
    }
    @Test
    public void orderStringTest() {
        Order order = new Order("1/2/12.3");
        assertEquals(1, order.getId());
        assertEquals(2, order.getCustomerId());
        assertEquals(12.3, order.getAmount());
    }


    //getter
    @Test
    public void getIdTest() {
        Order order = new Order(1, 2, 12.3);
        assertEquals(1, order.getId());
    }
    @Test
    public void getCustomerIdTest() {
        Order order = new Order(1, 2, 12.3);
        assertEquals(2, order.getCustomerId());
    }
    @Test
    public void getAmountTest() {
        Order order = new Order(1, 2, 12.3);
        assertEquals(12.3, order.getAmount());
    }


    //setter
    @Test
    public void setIdTest() {
        Order order = new Order(1, 2, 12.3);
        order.setId(11);
        assertEquals(11, order.getId());
    }
    @Test
    public void setCustomerIdTest() {
        Order order = new Order(1, 2, 12.3);
        order.setCustomerId(22);
        assertEquals(22, order.getCustomerId());
    }
    @Test
    public void setAmountTest() {
        Order order = new Order(1, 2, 12.3);
        order.setAmount(123.4);
        assertEquals(123.4, order.getAmount());
    }


    //toString
    @Test
    public void showInfoTest() {
        Order order = new Order(1, 2, 12.3);
        String text = "ID: 1\nCustomer: 2\nAmount: 12.3";
        assertEquals(text,order.showInfo());
    }


    //save
    @Test
    public void saveInfoTest() {
        Order order = new Order(1, 2, 12.3);
        String text = "1/2/12.3";
        assertEquals(text, order.saveInfo());
    }

}
