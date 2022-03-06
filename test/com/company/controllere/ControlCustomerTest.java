package com.company.controllere;

import com.company.modele.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.SpinnerUI;

import static org.junit.jupiter.api.Assertions.*;

class ControlCustomerTest {

    ControlCustomer controlCustomer;

    @BeforeEach
    public void init() {
        String path = "test/com/company/resources/customersTest";
        controlCustomer = new ControlCustomer(path);
    }

    @AfterEach
    public void close() {
        controlCustomer.deleteAll();
    }

    @Test
    public void addTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());
        assertEquals(4,controlCustomer.newCustomerId());

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;

        assertTrue(controlCustomer.existsCustomer(id));
        assertFalse(controlCustomer.existsCustomer(id+ controlCustomer.size()));
        assertTrue(controlCustomer.existsCustomer("Mail 2", "Nume 2"));
        assertFalse(controlCustomer.existsCustomer("Mail 88","Nume 88"));
    }

    @Test
    public void getCustomerTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;

        Customer customer = controlCustomer.getCustomer(id);

        assertEquals(id, customer.getId());
    }

    @Test
    public void getIdTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;
        assertTrue(id <= 3);

        assertEquals(id, controlCustomer.getCustomer(id).getId());
    }

    @Test
    public void getEmailTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        String[] email = {"Mail 1", "Mail 2", "Mail 3"};

        int id = (int) Math.floor(Math.random() * controlCustomer.size());

        assertEquals(email[id], controlCustomer.getCustomer(id+1).getEmail());
    }

    @Test
    public void getPasswordTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        String[] pwd = {"123", "234", "345"};

        int id = (int) Math.floor(Math.random() * controlCustomer.size());

        assertEquals(pwd[id], controlCustomer.getCustomer(id + 1).getPassword());
    }

    @Test
    public void getNameTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        String[] name = {"Nume 1", "Nume 2", "Nume 3"};

        int id = (int) Math.floor(Math.random() * controlCustomer.size());

        assertEquals(name[id], controlCustomer.getCustomer(id + 1).getFullName());
    }

    @Test
    public void deleteTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;

        assertNotEquals(null, controlCustomer.getCustomer(id));

        controlCustomer.deleteCustomer(controlCustomer.getCustomer(id));

        assertEquals(null, controlCustomer.getCustomer(id));
        assertEquals(2, controlCustomer.size());
    }

    @Test
    public void saveTest() {
        controlCustomer.load();
        assertEquals(0, controlCustomer.size());

        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        controlCustomer.save();

        controlCustomer.clearSession();
        assertEquals(0, controlCustomer.size());

        controlCustomer.load();
        assertEquals(3, controlCustomer.size());

        controlCustomer.deleteAll();
        assertEquals(0, controlCustomer.size());

        controlCustomer.load();
        assertEquals(0, controlCustomer.size());
    }

    @Test
    public void clearSessionTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        controlCustomer.clearSession();
        assertEquals(0,controlCustomer.size());
    }

    @Test
    public void loadTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        controlCustomer.save();

        controlCustomer.clearSession();
        assertEquals(0, controlCustomer.size());

        controlCustomer.load();
        assertEquals(3, controlCustomer.size());
    }

    @Test
    public void showTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/Parola 1/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/Parola 2/Nume 2"));
        controlCustomer.showCustomers();
    }

    @Test
    public void updateTest() {
        controlCustomer.addCustomer(new Customer("1/mail 1/pwd 1/name 1"));
        controlCustomer.addCustomer(new Customer("2/mail 2/pwd 2/name 2"));
        controlCustomer.addCustomer(new Customer("3/mail 3/pwd 3/name 3"));
        controlCustomer.addCustomer(new Customer("4/mail 4/pwd 4/name 4"));

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;

        String[] newEmail = {"mail 11", "mail 22", "mail 33", "mail 44"};
        String[] newPwd = {"pwd 11", "pwd 22", "pwd 33", "pwd 44"};
        String[] newName = {"name 11", "name 22", "name 33", "name 44"};

        controlCustomer.updateEmail(id, newEmail[id - 1]);
        controlCustomer.updatePassword(id, newPwd[id - 1]);
        controlCustomer.updateName(id, newName[id - 1]);
        assertEquals(newEmail[id - 1], controlCustomer.getCustomer(id).getEmail());
        assertEquals(newPwd[id - 1], controlCustomer.getCustomer(id).getPassword());
        assertEquals(newName[id - 1], controlCustomer.getCustomer(id).getFullName());
    }

    @Test
    public void existsTest() {
        controlCustomer.addCustomer(new Customer("1/Mail 1/123/Nume 1"));
        controlCustomer.addCustomer(new Customer("2/Mail 2/234/Nume 2"));
        controlCustomer.addCustomer(new Customer("3/Mail 3/345/Nume 3"));
        assertEquals(3,controlCustomer.size());

        int id = (int) Math.floor(Math.random() * controlCustomer.size()) + 1;

        assertTrue(controlCustomer.existsCustomer(id));
    }

}