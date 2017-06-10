package com.tw.salestax;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class SalesTaxTest {
    @Test
    public void customerShouldRecieveRecieptWithListOfItemsAndPrice() {
        String[] itemDetails = {"1 Book at 12.49"};
        SalesTax salesTax = new SalesTax(itemDetails);
        ArrayList<String > expectedItemList=new ArrayList<>(Arrays.asList("1 Book - 12.49"));
        assertEquals(expectedItemList, salesTax.printReciept());
    }
    @Test
    public void customerShouldRecieveRecieptWithListOfItemsAndPrices() {
        String[] itemDetails = {"1 Book at 12.49" ,"1 music CD at 14.99","1 chocolate bar at 0.85"};
        SalesTax salesTax = new SalesTax(itemDetails);
        ArrayList<String > expectedItemList=new ArrayList<>(Arrays.asList("1 Book - 12.49","1 music CD - 14.99","1 chocolate bar - 0.85"));
        assertEquals(expectedItemList, salesTax.printReciept());
    }

}