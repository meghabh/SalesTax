package com.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
public class SalesTaxTest{
    @Test
    public void taxShouldNotBeApplicableOnExemptedItems() {
        String[] itemDetails = {"1 book at 12.49"};
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        assertEquals(0.00,salesTax.getSalesTax());

    }
    @Test
    public void taxShouldBeApplicableOnImportedItems(){
        String[] itemDetails = {"1 imported box of chocolates at 10.00"};
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        assertEquals(0.50,salesTax.getSalesTax());
    }
    @Test
    public  void taxShouldBeApplicableOnNonExemptedItems(){
        String[] itemDetails = {"1 music CD at 14.99"};
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        assertEquals(1.50,salesTax.getSalesTax());

    }
    @Test
    public void shouldCalculateTotalPrice(){
        String[] itemDetails={"1 imported box of chocolates at 10.00","1 imported bottle of perfume at 47.50"};
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        assertEquals(65.15,salesTax.getTotalPrice());

    }
   @Test
    public void shouldGenerateReciept(){
       String[] itemDetails = {"1 book at 12.49"};
       ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
       shoppingBasket.createItem();
       SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
       salesTax.calculateBill();
       GenerateReciept generateReciept=new GenerateReciept(salesTax.getItemList(), salesTax);
       generateReciept.createReciept();
       ArrayList<String> expectedReciept =new ArrayList<>(Arrays.asList("1 book - 12.49","Sales Taxes - 0.0","Total - 12.49"));
       assertEquals(expectedReciept,generateReciept.getReceipt());
   }

}