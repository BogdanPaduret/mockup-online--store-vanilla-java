package com.company.controllere;

import com.company.modele.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlProductTest {

    ControlProduct controlProduct;

    @BeforeEach
    public void init() {
        System.out.println("\n===== Begin Test =====");
        String path = "test/com/company/resources/productsTest";
        controlProduct = new ControlProduct(path);
        System.out.println("===== controlProduct initialized =====");
    }

    @AfterEach
    public void close() {
        controlProduct.deleteAll();
        System.out.println("\n===== Database emptied =====");
        System.out.println("===== End Test =====\n");
    }


    //constructor
    @Test
    public void constructorTest() {
        System.out.println("\n+++ constructor test +++");
    }


    //create
    @Test
    public void addProductTest() {
        System.out.println("\n+++ addProduct test +++");
        System.out.println("--- creating products [");
        controlProduct.addProduct(new Product("1/mere/12.3/456.7"));
        controlProduct.addProduct(new Product("2/struguri/89.0/123.4"));
        controlProduct.addProduct(new Product("3/pere/56.7/890.1"));
        System.out.println("] products created ---");

        System.out.println("--- assert size ---");
        assertEquals(3, controlProduct.size());
    }
    @Test
    public void generateNewIdTest() {
        System.out.println("\n+++ new #id test +++");
        System.out.println("--- assert for empty list ---");
        assertEquals(0, controlProduct.generateNewId());

        System.out.println("--- creating products [");
        controlProduct.addProduct(new Product("1/mere/12.3/456.7"));
        controlProduct.addProduct(new Product("2/struguri/89.0/123.4"));
        controlProduct.addProduct(new Product("3/pere/56.7/890.1"));
        assertEquals(3, controlProduct.size());
        System.out.println("] products added to list ---");

        System.out.println("--- assert for filled list, no empty spots ---");
        assertEquals(4, controlProduct.generateNewId());

        System.out.println("--- removing product [");
        controlProduct.deleteProduct(controlProduct.getProduct(1));
        assertEquals(2,controlProduct.size());
        System.out.println("] product removed ---");

        System.out.println("--- assert for filled list, with empty spots ---");
        assertEquals(4, controlProduct.generateNewId());

        System.out.println("--- removing product [");
        controlProduct.deleteProduct(controlProduct.getProduct(3));
        assertEquals(1, controlProduct.size());
        System.out.println("] last product removed ---");

        System.out.println("--- assert for filled list, last entry removed ---");
        assertEquals(3, controlProduct.generateNewId());
    }


    //read
    @Test
    public void loadTest() {
        System.out.println("\n+++ load test +++");
        System.out.println("--- creating products [");
        controlProduct.addProduct(new Product("1/mere/12.3/456.7"));
        controlProduct.addProduct(new Product("2/struguri/89.0/123.4"));
        controlProduct.addProduct(new Product("3/pere/56.7/890.1"));
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");

        System.out.println("--- saving products [");
        controlProduct.save();
        System.out.println("] products saved ---");

        System.out.println("--- clearing session [");
        controlProduct.clearSession();
        assertEquals(0, controlProduct.size());
        System.out.println("] session cleared ---");

        System.out.println("--- loading [");
        controlProduct.load();
        assertEquals(3, controlProduct.size());
        System.out.println("] load complete ---");
    }
    @Test
    public void showAllTest() {
        System.out.println("\n+++ show all products test +++");
        System.out.println("--- creating products [");
        controlProduct.addProduct(new Product("1/mere/12.3/456.7"));
        controlProduct.addProduct(new Product("2/struguri/89.0/123.4"));
        controlProduct.addProduct(new Product("3/pere/56.7/890.1"));
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");

        System.out.println("--- showing products (no assert):");
        controlProduct.showAllProducts();
        System.out.println("] products showed ---");
    }
    @Test
    public void getProductTest_ID() {
        System.out.println("\n+++ test getting product using id +++");

        System.out.println("--- creating variables [");
        int[] id = {
                1,
                2,
                3
        };
        String[] name = {
                "mere",
                "struguri",
                "pere"
        };
        double[] price = {
                12.3,
                89.0,
                56.7
        };
        double[] stock = {
                456.7,
                123.4,
                890.1
        };
        int index = (int) (Math.random() * id.length);
        int getId = id[index];
        System.out.println("] variables created ---");

        System.out.println("--- creating products [");
        for (int i = 0; i < id.length; i++) {
            String input = "";
            input += id[i] + "/" + name[i] + "/" + price[i] + "/" + stock[i];
            controlProduct.addProduct(new Product(input));
        }
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");


        System.out.println("--- getting random product [");
        Product product = controlProduct.getProduct(getId);
        System.out.println("] random product created ---");

        System.out.println("--- begin asserts [");
        assertEquals(id[index], product.getId());
        assertEquals(name[index], product.getName());
        assertEquals(price[index], product.getPrice());
        assertEquals(stock[index], product.getStock());
        System.out.println("] asserts completed ---");
    }
    @Test
    public void getProductTest_Name() {
        System.out.println("\n+++ test getting product using name +++");

        System.out.println("--- creating variables [");
        int[] id = {
                1,
                2,
                3
        };
        String[] name = {
                "mere",
                "struguri",
                "pere"
        };
        double[] price = {
                12.3,
                89.0,
                56.7
        };
        double[] stock = {
                456.7,
                123.4,
                890.1
        };
        int index = (int) (Math.random() * id.length);
        String getname = name[index];
        System.out.println("] variables created ---");

        System.out.println("--- creating products [");
        for (int i = 0; i < id.length; i++) {
            String input = "";
            input += id[i] + "/" + name[i] + "/" + price[i] + "/" + stock[i];
            controlProduct.addProduct(new Product(input));
        }
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");


        System.out.println("--- getting random product [");
        Product product = controlProduct.getProduct(getname);
        System.out.println("] random product created ---");

        System.out.println("--- begin asserts [");
        assertEquals(id[index], product.getId());
        assertEquals(name[index], product.getName());
        assertEquals(price[index], product.getPrice());
        assertEquals(stock[index], product.getStock());
        System.out.println("] asserts completed ---");
    }
    @Test
    public void sizeTest() {
        System.out.println("\n+++ test size +++");

        System.out.println("--- creating product ---");
        controlProduct.addProduct(new Product("1/mere/12.3/456.7"));
        System.out.println("--- assert size 1 ---");
        assertEquals(1, controlProduct.size());

        System.out.println("--- creating product ---");
        controlProduct.addProduct(new Product("2/struguri/89.0/123.4"));
        System.out.println("--- assert size 2 ---");
        assertEquals(2, controlProduct.size());

        System.out.println("--- creating product ---");
        controlProduct.addProduct(new Product("3/pere/56.7/890.1"));
        System.out.println("--- assert size 3 ---");
        assertEquals(3, controlProduct.size());
    }
    @Test
    public void existsTest_ID() {
        System.out.println("\n+++ test exists using id +++");

        System.out.println("--- creating variables [");
        int[] id = {1, 2, 3};
        String[] name = {"mere", "struguri", "pere"};
        double[] price = {12.3, 89.0, 56.7};
        double[] stock = {456.7, 123.4, 890.1};

        System.out.println("] variables created ---");

        System.out.println("--- creating products [");
        for (int i = 0; i < id.length; i++) {
            String input = "";
            input += id[i] + "/" + name[i] + "/" + price[i] + "/" + stock[i];
            controlProduct.addProduct(new Product(input));
        }
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");

        System.out.println("--- asserting existance for existing products [");
        int indexTrue;
        int idTrue;
        for (int i = 0; i < 10; i++) {
            indexTrue = (int) (Math.random() * id.length);
            idTrue = id[indexTrue];
            assertTrue(controlProduct.exists(idTrue));
        }
        System.out.println("] assert complete ---");

        System.out.println("--- asserting for non-existent products [");
        int idFalse;
        for (int i = 0; i < 5; i++) {
            idFalse = (int) (Math.random() * 1000000) + id.length;
            assertFalse(controlProduct.exists(idFalse));
        }
        System.out.println("] assert complete ---");
    }
    @Test
    public void existsTest_Name() {
        System.out.println("\n+++ test exists using name +++");

        System.out.println("--- creating variables [");
        int[] id = {1, 2, 3};
        String[] name = {"mere", "struguri", "pere"};
        double[] price = {12.3, 89.0, 56.7};
        double[] stock = {456.7, 123.4, 890.1};

        System.out.println("] variables created ---");

        System.out.println("--- creating products [");
        for (int i = 0; i < id.length; i++) {
            String input = "";
            input += id[i] + "/" + name[i] + "/" + price[i] + "/" + stock[i];
            controlProduct.addProduct(new Product(input));
        }
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");

        System.out.println("--- asserting existance for existing products [");
        int indexTrue;
        String nameTrue;
        for (int i = 0; i < 10; i++) {
            indexTrue = (int) (Math.random() * id.length);
            nameTrue = name[indexTrue];
            assertTrue(controlProduct.exists(nameTrue));
        }
        System.out.println("] assert complete ---");

        System.out.println("--- asserting for non-existent products [");
        String nameFalse="random";
        assertFalse(controlProduct.exists(nameFalse));
        System.out.println("] assert complete ---");
    }


    //update
    @Test
    public void updateNameTest() {

    }

}