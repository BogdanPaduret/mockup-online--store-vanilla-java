package com.company.modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailsTest {

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
    public void orderDetailsVarTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(1, orderDetails.getId());
        assertEquals(2, orderDetails.getOrderId());
        assertEquals(3, orderDetails.getProductId());
        assertEquals(45.6, orderDetails.getPrice());
        assertEquals(78.9, orderDetails.getQty());
    }
    @Test
    public void orderDetailsStringTest() {
        OrderDetails orderDetails = new OrderDetails("1/2/3/45.6/78.9");
        assertEquals(1, orderDetails.getId());
        assertEquals(2, orderDetails.getOrderId());
        assertEquals(3, orderDetails.getProductId());
        assertEquals(45.6, orderDetails.getPrice());
        assertEquals(78.9, orderDetails.getQty());
    }


    //getter
    @Test
    public void getIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(1, orderDetails.getId());
    }
    @Test
    public void getOrderIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(2, orderDetails.getOrderId());
    }
    @Test
    public void getProductIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(3, orderDetails.getProductId());
    }
    @Test
    public void getPriceTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(45.6, orderDetails.getPrice());
    }
    @Test
    public void getQtyTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        assertEquals(78.9, orderDetails.getQty());
    }


    //setter
    @Test
    public void setIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        orderDetails.setId(11);
        assertEquals(11, orderDetails.getId());
    }
    @Test
    public void setOrderIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        orderDetails.setOrderId(22);
        assertEquals(22, orderDetails.getOrderId());
    }
    @Test
    public void setProductIdTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        orderDetails.setProductId(33);
        assertEquals(33, orderDetails.getProductId());
    }
    @Test
    public void setPriceTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        orderDetails.setPrice(945.6);
        assertEquals(945.6, orderDetails.getPrice());
    }
    @Test
    public void setQtyTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        orderDetails.setQty(978.9);
        assertEquals(978.9, orderDetails.getQty());
    }


    //show
    @Test
    public void showTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        String text = "ID: 1\nOrder ID: 2\nProduct ID: 3\nPrice: 45.6\nQuantity: 78.9";
        assertEquals(text, orderDetails.show());
    }


    //save
    @Test
    public void saveInfoTest() {
        OrderDetails orderDetails = new OrderDetails(1, 2, 3, 45.6, 78.9);
        String text = "1/2/3/45.6/78.9";
        assertEquals(text, orderDetails.saveInfo());
    }
}