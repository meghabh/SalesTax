package com.tw.salestax;

import org.junit.Test;
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
        String[] itemDetails = {"1 book at 12.49","1 music CD at 14.99","1 chocolate bar at 0.85"};
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        assertEquals(29.83,salesTax.getTotalPrice());

    }


}