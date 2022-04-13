package com.company.modele.users;

import com.company.modele.users.Customer;
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
        Customer customer = new Customer(1, "Firstname Lastname", "Email", "password");
        assertEquals(1, customer.getId());
        assertEquals("Email", customer.getEmail());
        assertEquals("password", customer.getPassword());
        assertEquals("Firstname Lastname", customer.getFullName());
    }
    @Test
    public void customerStringTest() {
        Customer customer = new Customer("1/Firstname Lastname/Email/password");
        assertEquals(1, customer.getId());
        assertEquals("Email", customer.getEmail());
        assertEquals("password", customer.getPassword());
        assertEquals("Firstname Lastname", customer.getFullName());
        assertEquals("customer", customer.getType());
    }


    //toString test
    @Test
    public void toStringTest() {
        Customer customer = new Customer(1, "Firstname Lastname", "email", "password");
        String text = "Type: customer\nID: 1\nName: Firstname Lastname\nEmail: email\nPassword: password\n";
        assertEquals(text, customer.toString());
    }

    //equals test
    @Test
    public void equalsTest() {
        Customer customer = new Customer(1, "Firstname Lastname", "email", "password");
        Customer customer0 = new Customer(1, "Firstname Lastname", "email", "password");
        Customer customer1 = new Customer(2, "Firstname Lastname", "email", "password");
        Customer customer2 = new Customer(1, "Firstname Lastname Middlename", "email", "password");
        Customer customer3 = new Customer(1, "Firstname Lastname", "email3", "password");
        Customer customer4 = new Customer(1, "Firstname Lastname", "email", "password4");

        assertTrue(customer.equals(customer0));
        assertFalse(customer.equals(customer1));
        assertFalse(customer.equals(customer2));
        assertFalse(customer.equals(customer3));
        assertFalse(customer.equals(customer4));


    }

    //save string test
    @Test
    public void saveInfoTest() {
        Customer customer = new Customer(1, "Firstname Lastname", "email", "password");
        String text = "customer/1/Firstname Lastname/email/password";
        assertEquals(text,customer.saveInfo());
    }
}
