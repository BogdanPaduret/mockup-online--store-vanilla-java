package com.company.modele.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

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
    void getType() {
        User user = new User("user/1/Firstname Lastname/Email/passWord") {

        };
        assertEquals("user", user.getType());
    }

    @Test
    void setType() {
        User user = new User("user/1/Firstname Lastname/Email/passWord") {

        };
        user.setType("non-user");
        assertEquals("non-user", user.getType());
    }




    @Test
    void getId() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        assertEquals(1, user.getId());
    }

    @Test
    void setId() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        user.setId(2);
        assertEquals(2, user.getId());
    }




    @Test
    void getFullName() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        assertEquals("Firstname Lastname",user.getFullName());
    }

    @Test
    void setFullName() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        user.setFullName("New name");
        assertEquals("New name", user.getFullName());
    }




    @Test
    void getEmail() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        assertEquals("Email",user.getEmail());
    }

    @Test
    void setEmail() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        user.setEmail("new email");
        assertEquals("new email",user.getEmail());
    }




    @Test
    void getPassword() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        assertEquals("passWord",user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };
        user.setPassword("new Password");
        assertEquals("new Password",user.getPassword());
    }




    @Test
    void testToString() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){

        };

        String string = "";

        string += "Type: user\n";
        string += "ID: 1\n";
        string += "Name: Firstname Lastname\n";
        string += "Email: Email\n";
        string += "Password: passWord\n";

        assertEquals(string,user.toString());
    }

    @Test
    void testEquals() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){};
        User user0 = new User("user/1/Firstname Lastname/Email/passWord"){};
        User user1 = new User("user1/1/Firstname Lastname/Email/passWord"){};
        User user2 = new User("user/2/Firstname Lastname/Email/passWord"){};
        User user3 = new User("user/1/Firstname Lastname Middlename/Email/passWord"){};
        User user4 = new User("user/1/Firstname Lastname/Email4/passWord"){};
        User user5 = new User("user/1/Firstname Lastname/Email/passWord5"){};

        boolean state = user.equals(user0);

        assertTrue(user.equals(user0));
        assertFalse(user.equals(user1));
        assertFalse(user.equals(user2));
        assertFalse(user.equals(user3));
        assertFalse(user.equals(user4));
        assertFalse(user.equals(user5));
    }

    @Test
    void saveInfo() {
        User user = new User("user/1/Firstname Lastname/Email/passWord"){};

        String string = "";
        string += "user/";
        string += "1/";
        string += "Firstname Lastname/";
        string += "Email/";
        string += "passWord";

        assertEquals(string,user.saveInfo());
    }
}