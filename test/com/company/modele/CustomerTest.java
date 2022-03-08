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
        Customer customer = new Customer("1/Email/pwd/Firstname Lastname/false");
        assertEquals(1, customer.getId());
        assertEquals("Email", customer.getEmail());
        assertEquals("pwd", customer.getPassword());
        assertEquals("Firstname Lastname", customer.getFullName());
        assertFalse(customer.isAdmin());
    }

    @Test
    public void customerVarAdminTest() {
        Customer customer;
        customer = new Customer(1, "Email1", "pwd1", "Firstname1 Lastname1", true);
        assertEquals(1, customer.getId());
        assertEquals("Email1", customer.getEmail());
        assertEquals("pwd1", customer.getPassword());
        assertEquals("Firstname1 Lastname1", customer.getFullName());
        assertTrue(customer.isAdmin());
        customer = new Customer(2, "Email2", "pwd2", "Firstname2 Lastname2", false);
        assertEquals(2, customer.getId());
        assertEquals("Email2", customer.getEmail());
        assertEquals("pwd2", customer.getPassword());
        assertEquals("Firstname2 Lastname2", customer.getFullName());
        assertFalse(customer.isAdmin());
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
    @Test
    public void isAdminTest() {
        Customer customer1 = new Customer(1, "Email", "pwd", "Firstname Lastname");
        Customer customer2 = new Customer(2, "Email 2", "pwd 2", "Firstname2 Lastname2", true);
        Customer customer3 = new Customer(3, "Email 3", "pwd 3", "Firstname3 Lastname3", false);
        Customer customer4 = new Customer("4/Email4/pwd4/Firstname4 Lastname4/true");
        Customer customer5 = new Customer("5/Email5/pwd5/Firstname 5 Lastname5/false");
        assertFalse(customer1.isAdmin());
        assertTrue(customer2.isAdmin());
        assertFalse(customer3.isAdmin());
        assertTrue(customer4.isAdmin());
        assertFalse(customer5.isAdmin());
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

    @Test
    public void setAdminTest() {
        Customer customer = new Customer("1/Email/pwd/Firstname Lastname/false");
        assertFalse(customer.isAdmin());
        customer.setAdmin(true);
        assertTrue(customer.isAdmin());
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
        String text = "1/Email/pwd/Firstname Lastname/false";
        assertEquals(text,customer.saveInfo());
    }
}
