package com.company.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewCustomerTest {

    private ViewCustomer viewCustomer;


    @BeforeEach
    public void init() {
        viewCustomer = new ViewCustomer();
    }

    @Test
    public void menuTest() {
        viewCustomer.menu();
    }

}