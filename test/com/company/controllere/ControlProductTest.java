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


    //save + load
    @Test
    public void toSaveTest() {

        //initializare produse
        System.out.println("\n+++ save string test +++");

        System.out.println("--- creating variables [");
        String[][] arr = {
                {"1","2","3"},
                {"mere", "struguri", "pere"},
                {"12.3", "89.0", "56.7"},
                {"456.7", "123.4", "890.1"}
        };
        System.out.println("] variables created ---");

        System.out.println("--- creating products [");
        for (int i = 0; i < arr[0].length; i++) {
            String input = "";
            input += arr[0][i] + "/" + arr[1][i] + "/" + arr[2][i] + "/" + arr[3][i];
            controlProduct.addProduct(new Product(input));
        }
        assertEquals(3, controlProduct.size());
        System.out.println("] products created ---");

        //verificare cod salvat
        System.out.println("--- asserting save information lines [");
        String separator = "/";
        String text = "";
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println("- checking product with index " + i + " -");
            for (int j = 0; j < arr.length; j++) {
                text += arr[j][i];
                if (j < arr[0].length) {
                    text += "/";
                }
            }
            assertEquals(text, controlProduct.getProduct(arr[1][i]).saveInfo());
            text = "";
        }
        System.out.println("] assertion complete ---");
    }
    @Test
    public void saveLoadTest() {
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
        System.out.println("\n+++ exists using id test +++");

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
        System.out.println("\n+++ exists using name test +++");

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
        System.out.println("\n+++ update name test +++");

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

        System.out.println("--- updating names [");
        controlProduct.updateName(1, "mere golden");
        controlProduct.updateName(2, "black grapes");
        controlProduct.updateName(3, "weiße Birne");
        System.out.println("] update complete ---");

        System.out.println("--- asserting updates [");
        assertEquals("mere golden", controlProduct.getProduct(1).getName());
        assertEquals("black grapes", controlProduct.getProduct(2).getName());
        assertEquals("weiße Birne", controlProduct.getProduct(3).getName());
        System.out.println("] assertion complete ---");
    }
    @Test
    public void updatePriceTest() {
        System.out.println("\n+++ update price test +++");

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

        System.out.println("--- updating names [");
        controlProduct.updatePrice(1, 1.1);
        controlProduct.updatePrice(2, 22.22);
        controlProduct.updatePrice(3, 333.333);
        System.out.println("] update complete ---");

        System.out.println("--- asserting updates [");
        assertEquals(1.1, controlProduct.getProduct(1).getPrice());
        assertEquals(22.22, controlProduct.getProduct(2).getPrice());
        assertEquals(333.333, controlProduct.getProduct(3).getPrice());
        System.out.println("] assertion complete ---");
    }
    @Test
    public void updateStockTest() {
        System.out.println("\n+++ update stock test +++");

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

        System.out.println("--- updating names [");
        controlProduct.updateStock(1, 999.999);
        controlProduct.updateStock(2, 88.88);
        controlProduct.updateStock(3, 7.7);
        System.out.println("] update complete ---");

        System.out.println("--- asserting updates [");
        assertEquals(999.999, controlProduct.getProduct(1).getStock());
        assertEquals(88.88, controlProduct.getProduct(2).getStock());
        assertEquals(7.7, controlProduct.getProduct(3).getStock());
        System.out.println("] assertion complete ---");
    }


    //delete
    @Test
    public void deleteProductTest_Product() {

        //initializare produse
        System.out.println("\n+++ update stock test +++");

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

        //initializare metode ce trebuie testate
        System.out.println("--- deleting product [");
        controlProduct.deleteProduct(controlProduct.getProduct(2));
        System.out.println("] product deleted ---");

        //verificare rezultate
        System.out.println("--- asserting attributes ---");
        assertEquals(2, controlProduct.size());
        assertTrue(controlProduct.exists(1));
        assertFalse(controlProduct.exists(2));
        assertTrue(controlProduct.exists(3));
        System.out.println("] assertion complete ---");
    }
    @Test
    public void deleteProductTest_ID() {

        //initializare produse
        System.out.println("\n+++ update stock test +++");

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

        //initializare metode ce trebuie testate
        System.out.println("--- deleting product [");
        controlProduct.deleteProduct(2);
        System.out.println("] product deleted ---");

        //verificare rezultate
        System.out.println("--- asserting attributes ---");
        assertEquals(2, controlProduct.size());
        assertTrue(controlProduct.exists(1));
        assertFalse(controlProduct.exists(2));
        assertTrue(controlProduct.exists(3));
        System.out.println("] assertion complete ---");
    }
    @Test
    public void clearSessionTest() {

        //initializare produse
        System.out.println("\n+++ update stock test +++");

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

        //initializare metode ce trebuie testate
        controlProduct.clearSession();

        //verificare rezultate
        assertEquals(0, controlProduct.size());

    }
    @Test
    public void deleteAllTest() {

        //initializare produse
        System.out.println("\n+++ update stock test +++");

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

        //salvare + golire sesiune
        System.out.println("--- saving and clearing session [");
        controlProduct.save();
        controlProduct.clearSession();
        assertEquals(0, controlProduct.size());
        System.out.println("] products saved and session cleared ---");

        //incarcare si verificare
        System.out.println("--- loading and checking status [");
        controlProduct.load();
        assertEquals(3, controlProduct.size());
        assertTrue(controlProduct.exists(1));
        assertTrue(controlProduct.exists(2));
        assertTrue(controlProduct.exists(3));
        assertFalse(controlProduct.exists(4));
        System.out.println("] products loaded ---");

        //initializare metoda ce trebuie testate
        controlProduct.deleteAll();

        //verificare rezultat
        assertEquals(0, controlProduct.size());

    }

}