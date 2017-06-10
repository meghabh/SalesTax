package com.tw.salestax;

import java.util.ArrayList;

public class SalesTax {
    CalculateTax calculateTax;
   // ArrayList<String>  ItemList=new ArrayList<>();
    SalesTax(String[] itemDetails){
        calculateTax=new CalculateTax(itemDetails);
    }
    public ArrayList<String> printReciept() {
        calculateTax.calculateTotalPrice();
        return calculateTax.getReciept();
    }



}