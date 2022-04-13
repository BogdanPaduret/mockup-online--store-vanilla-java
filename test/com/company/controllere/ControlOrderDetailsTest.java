package com.company.controllere;

import com.company.modele.OrderDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderDetailsTest {

    ControlOrderDetails controlDetails;

    @BeforeEach
    void setUp() {
        System.out.println("======== begin test ========");
        String path = "test/com/company/resources/orderDetailsTest";
        controlDetails = new ControlOrderDetails(path);
        System.out.println("===== test initialized =====");
    }

    @AfterEach
    void tearDown() {
        controlDetails.deleteAll();
        System.out.println("\n===== database emptied =====");
        System.out.println("========= end test =========");
    }


    //constructor
    @Test
    public void constructorTest() {

    } //aceeasi intrebare ca si la celalaltul


    //save+load
    @Test
    public void toSaveTest() {

        System.out.println("\n+++ save string test +++");

        //initializare detalii
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        assertEquals(3,controlDetails.size());
        System.out.println("] details created");

        //verificare cod salvat
        System.out.println(" - asserting save information line [");
        String s = "/";
        String text = "";
        for (int i = 0; i < arr.length; i++) {
            int id = Integer.parseInt(arr[i][0]);
            System.out.println("-- checking detail with id " + id + " [");
            for (int j = 0; j < arr[i].length; j++) {
                text += arr[i][j];
                if (j < arr[i].length - 1) {
                    text += s;
                }
            }
            assertEquals(text,controlDetails.getOrderDetails(id).saveInfo());
            System.out.println("] detail clear");
            text = "";
        }
        System.out.println("] assertion complete");
    }
    @Test
    public void saveLoadTest() {

        System.out.println("\n+++ save and load test +++");

        //initializare detalii
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        assertEquals(3,controlDetails.size());
        System.out.println("] details created");

        //salvare
        System.out.println("- saving order details [");
        controlDetails.save();
        System.out.println("] details saved");

        //eliberare sesiune
        System.out.println("- clearing session [");
        controlDetails.clearSession();
        assertEquals(0, controlDetails.size());
        System.out.println("] session cleared");

        //incarcare
        System.out.println("- loading [");
        controlDetails.load();
        assertEquals(3, controlDetails.size());
        System.out.println("] load complete");
    }


    //create
    @Test
    public void addTest_Object() {
        System.out.println("+++ add details using object test +++");

        //initializare detalii
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        System.out.println("] details created");

        //asserts
        System.out.println("- asserting size [");
        assertEquals(3,controlDetails.size());
        System.out.println("] assertion complete");

    }
    @Test
    public void addTest_String() {

        System.out.println("+++ add details using string test +++");

        //initializare detalii
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOderDetails(input);
        }
        System.out.println("] details created");

        //asserts
        System.out.println("- asserting size [");
        assertEquals(3,controlDetails.size());
        System.out.println("] assertion complete");
    }
    @Test
    public void generateNewIdTest() {
        System.out.println("+++ new ID test +++");
        int id = 0;

        //empty list id
        System.out.println("- assert ID for empty list [");
        id = controlDetails.newOrderDetailsId();
        assertEquals(0, id);

        //initialize details
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        assertEquals(3,controlDetails.size());
        System.out.println("] details created");

        //assert for filled list, no empty spots
        System.out.println("- asserting for filled list without empty spots [");
        id = controlDetails.newOrderDetailsId();
        assertEquals(4, id);
        System.out.println("] assertion complete");

        //assert for filled list with empty spots
        System.out.println("- deleting detail 2 [");
        controlDetails.deleteOrderDetails(2);
        assertEquals(2, controlDetails.size());
        System.out.println("] deletion complete");
        System.out.println("- asserting for filled list with empty spot within list[");
        id = controlDetails.newOrderDetailsId();
        assertEquals(4, id);
        System.out.println("- assertion complete");

        controlDetails.showAllOrderDetails();

        //assert for filled list with last entries deleted
        System.out.println("- deleting detail 3 [");
        controlDetails.deleteOrderDetails(3);
        System.out.println("-- assertion of size");
        assertEquals(1, controlDetails.size());
        System.out.println("] deletion complete");

        System.out.println("- asserting for filled list with last entries deleted [");
        id = controlDetails.newOrderDetailsId();
        assertEquals(2, id);
        System.out.println("] assertion complete");

    }


    //read
    @Test
    public void showAllTest() {
        System.out.println("+++ toString all test +++");

        //initializare detalii
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        assertEquals(3,controlDetails.size());
        System.out.println("] details created");

        //afisare
        controlDetails.showAllOrderDetails();
    }


    //delete
    @Test
    public void deleteDetailTest_ID() {
        System.out.println("+++ delete details test +++");

        //initialize details
        System.out.println("- creating variables [");
        String[][] arr = {
                //{id,orderId,productId,price,quantity}
                {"1", "11", "111", "1.99", "100.1"},
                {"2", "22", "222", "2.99", "200.2"},
                {"3", "33", "333", "3.99", "300.3"}
        };
        System.out.println("] variables created");

        System.out.println("- creating details [");
        for (int i = 0; i < arr.length; i++) {
            String input = "";
            for (int j = 0; j < arr[0].length; j++) {
                input += arr[i][j];
                if (j<arr[i].length-1) {
                    input += "/";
                }
            }
            controlDetails.addOrderDetails(new OrderDetails(input));
        }
        assertEquals(3,controlDetails.size());
        System.out.println("] details created");

        //deleting middle element using id
        controlDetails.deleteOrderDetails(2);
        assertEquals(2, controlDetails.size());
        assertTrue(controlDetails.exists(1));
        assertFalse(controlDetails.exists(2));
        assertTrue(controlDetails.exists(3));

        //adding element back
        controlDetails.addOrderDetails(new OrderDetails("2/22/222/2.99/200.2"));
        assertEquals(3, controlDetails.size());

        //delete last element using id
        controlDetails.deleteOrderDetails(3);
        assertEquals(2, controlDetails.size());
        assertTrue(controlDetails.exists(1));
        assertTrue(controlDetails.exists(2));
        assertFalse(controlDetails.exists(3));

        //adding element back
        controlDetails.addOderDetails("3/33/333/3.99/300.3");

        //delete first element using id
        controlDetails.deleteOrderDetails(1);
        assertEquals(2, controlDetails.size());
        assertFalse(controlDetails.exists(1));
        assertTrue(controlDetails.exists(2));
        assertTrue(controlDetails.exists(3));

        //delete also second element
        controlDetails.deleteOrderDetails(2);
        assertEquals(1, controlDetails.size());
        assertFalse(controlDetails.exists(1));
        assertFalse(controlDetails.exists(2));
        assertTrue(controlDetails.exists(3));

        //delete also the last element
        controlDetails.deleteOrderDetails(3);
        assertEquals(0, controlDetails.size());
        assertFalse(controlDetails.exists(1));
        assertFalse(controlDetails.exists(2));
        assertFalse(controlDetails.exists(3));

    }
}