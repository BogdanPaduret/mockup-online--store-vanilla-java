package com.company.modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

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


    //constructor
    @Test
    public void productVarTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        assertEquals(1, product.getId());
        assertEquals("Name", product.getName());
        assertEquals(123.4, product.getPrice());
        assertEquals(567.8, product.getStock());
    }
    @Test
    public void productStringTest() {
        Product product = new Product("1/Name/123.4/567.8");
        assertEquals(1, product.getId());
        assertEquals("Name", product.getName());
        assertEquals(123.4, product.getPrice());
        assertEquals(567.8, product.getStock());
    }


    //get
    @Test
    public void getIdTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        assertEquals(1, product.getId());
    }
    @Test
    public void getNameTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        assertEquals("Name", product.getName());
    }
    @Test
    public void getPriceTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        assertEquals(123.4, product.getPrice());
    }
    @Test
    public void getStockTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        assertEquals(567.8, product.getStock());
    }


    //set
    @Test
    public void setIdTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        product.setId(11);
        assertEquals(11, product.getId());
        assertEquals("Name", product.getName());
        assertEquals(123.4, product.getPrice());
        assertEquals(567.8, product.getStock());
    }
    @Test
    public void setNameTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        product.setName("new Name");
        assertEquals(1, product.getId());
        assertEquals("new Name", product.getName());
        assertEquals(123.4, product.getPrice());
        assertEquals(567.8, product.getStock());
    }
    @Test
    public void setPriceTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        product.setPrice(999.9);
        assertEquals(1, product.getId());
        assertEquals("Name", product.getName());
        assertEquals(999.9, product.getPrice());
        assertEquals(567.8, product.getStock());
    }
    @Test
    public void setStockTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        product.setStock(999.9);
        assertEquals(1, product.getId());
        assertEquals("Name", product.getName());
        assertEquals(123.4, product.getPrice());
        assertEquals(999.9, product.getStock());
    }


    //toString
    @Test
    public void showTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        String text = "ID: 1\nName: Name\nPrice: 123.4\nStock: 567.8";
        assertEquals(text, product.show());
    }


    //save
    @Test
    public void saveTest() {
        Product product = new Product(1, "Name", 123.4, 567.8);
        String text = "1/Name/123.4/567.8";
        assertEquals(text, product.saveInfo());
    }
}