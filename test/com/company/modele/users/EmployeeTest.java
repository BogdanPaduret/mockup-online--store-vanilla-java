package com.company.modele.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @BeforeEach
    void setUp() {
        System.out.println("==============");
        System.out.println("Test beginning");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test ended");
        System.out.println("==========");
    }

    @Test
    void getIncome() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        assertEquals(123.45, employee1.getIncome());
        assertEquals(234.56,employee2.getIncome());
    }

    @Test
    void setIncome() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        employee1.setIncome(1230.45);
        employee2.setIncome(2340.56);

        assertEquals(1230.45, employee1.getIncome());
        assertEquals(2340.56, employee2.getIncome());

    }

    @Test
    void getManagerId() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        assertEquals(2, employee1.getManagerId());
        assertEquals(3, employee2.getManagerId());

    }

    @Test
    void setManagerId() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        employee1.setManagerId(20);
        employee2.setManagerId(30);

        assertEquals(20, employee1.getManagerId());
        assertEquals(30, employee2.getManagerId());

    }

    @Test
    void testToString() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        String string1 = "";
        String string2 = "";

        string1 += "Type: Type1\n";
        string1 += "ID: 1\n";
        string1 += "Name: Firstname1 Lastname1\n";
        string1 += "Email: Email1\n";
        string1 += "Password: password1\n";
        string1 += "Income: 123.45\n";
        string1 += "Manager ID: 2\n";

        string2 += "Type: Type2\n";
        string2 += "ID: 2\n";
        string2 += "Name: Firstname2 Lastname2\n";
        string2 += "Email: Email2\n";
        string2 += "Password: password2\n";
        string2 += "Income: 234.56\n";
        string2 += "Manager ID: 3\n";

        assertEquals(string1, employee1.toString());
        assertEquals(string2, employee2.toString());

    }

    @Test
    void testEquals() {
        Employee employee=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee0=new Employee("Type1/1/Firstname1 Lastname1/Email1/password1/123.45/2") {};
        Employee employee1=new Employee("Type11", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type1/12/Firstname1 Lastname1/Email1/password1/123.45/2") {};
        Employee employee3=new Employee("Type1", 1, "Firstname3 Lastname3", "Email1", "password1", 123.45, 2) {};
        Employee employee4=new Employee("Type1/1/Firstname1 Lastname1/Email4/password1/123.45/2") {};
        Employee employee5=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password5", 123.45, 2) {};
        Employee employee6=new Employee("Type1/1/Firstname1 Lastname1/Email1/password1/1236.45/2") {};
        Employee employee7=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 7) {};

        assertTrue(employee.equals(employee0));
        assertFalse(employee.equals(employee1));
        assertFalse(employee.equals(employee2));
        assertFalse(employee.equals(employee3));
        assertFalse(employee.equals(employee4));
        assertFalse(employee.equals(employee5));
        assertFalse(employee.equals(employee6));
        assertFalse(employee.equals(employee7));
    }

    @Test
    void saveInfo() {
        Employee employee1=new Employee("Type1", 1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2) {};
        Employee employee2=new Employee("Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3") {};

        String string1 = "Type1/1/Firstname1 Lastname1/Email1/password1/123.45/2";
        String string2 = "Type2/2/Firstname2 Lastname2/Email2/password2/234.56/3";

        assertEquals(string1, employee1.saveInfo());
        assertEquals(string2, employee2.saveInfo());

    }
}