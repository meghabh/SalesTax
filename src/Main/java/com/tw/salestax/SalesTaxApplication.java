package com.tw.salestax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SalesTaxApplication {
    public static void main(String[] args) {
        ArrayList<String> itemDetails=new ArrayList<>();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
            while(line.length()!=0){
                itemDetails.add(line);
                line=bufferedReader.readLine();

            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
        ShoppingBasket shoppingBasket = new ShoppingBasket(itemDetails);
        shoppingBasket.createItem();
        SalesTax salesTax = new SalesTax(shoppingBasket.getItemList());
        salesTax.calculateBill();
        GenerateReciept generateReciept=new GenerateReciept(salesTax.getItemList(), salesTax);
        generateReciept.createReciept();
        System.out.println(generateReciept.getReceipt());

    }
}
