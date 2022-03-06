package com.company.modele;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

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
    public void customerVarTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        assertEquals(1, customer.getId());
        assertEquals("Email", customer.getEmail());
        assertEquals("pwd", customer.getPassword());
        assertEquals("Firstname Lastname", customer.getFullName());
    }
    @Test
    public void customerStringTest() {
        Customer customer = new Customer("1/Email/pwd/Firstname Lastname");
        assertEquals(1, customer.getId());
        assertEquals("Email", customer.getEmail());
        assertEquals("pwd", customer.getPassword());
        assertEquals("Firstname Lastname", customer.getFullName());
    }


    //getter test
    @Test
    public void getIdTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        assertEquals(1, customer.getId());
    }
    @Test
    public void getEmailTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        assertEquals("Email", customer.getEmail());
    }
    @Test
    public void getPasswordTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        assertEquals("pwd", customer.getPassword());
    }
    @Test
    public void getFullnameTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        assertEquals("Firstname Lastname", customer.getFullName());
    }


    //setter test
    @Test
    public void setIdTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        customer.setId(2);
        assertEquals(2, customer.getId());
    }
    @Test
    public void setEmailTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        customer.setEmail("new Email");
        assertEquals("new Email", customer.getEmail());
    }
    @Test
    public void setPasswordTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        customer.setPassword("new password");
        assertEquals("new password", customer.getPassword());
    }
    @Test
    public void setFullnameTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        customer.setFullName("New name");
        assertEquals("New name", customer.getFullName());
    }


    //show test
    @Test
    public void showTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        String text = "ID: 1\nEmail: Email\nName: Firstname Lastname";
        assertEquals(text, customer.show());
    }


    //save string test
    @Test
    public void saveInfoTest() {
        Customer customer = new Customer(1, "Email", "pwd", "Firstname Lastname");
        String text = "1/Email/pwd/Firstname Lastname";
        assertEquals(text,customer.saveInfo());
    }
}
