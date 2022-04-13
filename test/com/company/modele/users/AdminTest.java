package com.company.modele.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

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
    void getRoleGroup() {
        Admin admin1 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin2 = new Admin("2/Firstname2 Lastname2/Email2/password2/234.56/3/rolegroup2");
        assertEquals("rolegroup1", admin1.getRoleGroup());
        assertEquals("rolegroup2", admin2.getRoleGroup());
    }

    @Test
    void setRoleGroup() {
        Admin admin1 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin2 = new Admin("2/Firstname2 Lastname2/Email2/password2/234.56/3/rolegroup2");
        admin1.setRoleGroup("new rolegroup1");
        admin2.setRoleGroup("new rolegroup2");
        assertEquals("new rolegroup1", admin1.getRoleGroup());
        assertEquals("new rolegroup2", admin2.getRoleGroup());
    }



    @Test
    void testToString() {
        Admin admin1 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin2 = new Admin("2/Firstname2 Lastname2/Email2/password2/234.56/3/rolegroup2");

        String string1 = "Type: admin\nID: 1\nName: Firstname1 Lastname1\nEmail: Email1\nPassword: password1\nIncome: 123.45\nManager ID: 2\nAdministrator role group: rolegroup1\n";
        String string2 = "Type: admin\nID: 2\nName: Firstname2 Lastname2\nEmail: Email2\nPassword: password2\nIncome: 234.56\nManager ID: 3\nAdministrator role group: rolegroup2\n";

        assertEquals(string1, admin1.toString());
        assertEquals(string2, admin2.toString());
    }

    @Test
    void testEquals() {
        Admin admin0 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin1 = new Admin("1/Firstname1 Lastname1/Email1/password1/123.45/2/rolegroup1");
        Admin admin2 = new Admin(2, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin3 = new Admin("1/Firstname3 Lastname3/Email1/password1/123.45/2/rolegroup1");
        Admin admin4 = new Admin(1, "Firstname1 Lastname1", "Email4", "password1", 123.45, 2, "rolegroup1");
        Admin admin5 = new Admin("1/Firstname1 Lastname1/Email1/password5/123.45/2/rolegroup1");
        Admin admin6 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 234.56, 2, "rolegroup1");
        Admin admin7 = new Admin("1/Firstname1 Lastname1/Email1/password1/123.45/3/rolegroup1");
        Admin admin8 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup2");

        assertTrue(admin0.equals(admin1));
        assertFalse(admin0.equals(admin2));
        assertFalse(admin0.equals(admin3));
        assertFalse(admin0.equals(admin4));
        assertFalse(admin0.equals(admin5));
        assertFalse(admin0.equals(admin6));
        assertFalse(admin0.equals(admin7));
        assertFalse(admin0.equals(admin8));

    }

    @Test
    void saveInfo() {
        Admin admin1 = new Admin(1, "Firstname1 Lastname1", "Email1", "password1", 123.45, 2, "rolegroup1");
        Admin admin2 = new Admin("2/Firstname2 Lastname2/Email2/password2/234.56/3/rolegroup2");
        String string1 = "admin/1/Firstname1 Lastname1/Email1/password1/123.45/2/rolegroup1";
        String string2 = "admin/2/Firstname2 Lastname2/Email2/password2/234.56/3/rolegroup2";
        assertEquals(string1, admin1.saveInfo());
        assertEquals(string2, admin2.saveInfo());
    }
}