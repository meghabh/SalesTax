package com.tw.salestax;

import java.util.List;

public class SalesTax {
    List<Item> items;
    CalculateTax calculateTax;

    SalesTax(List<Item> items) {
        this.items = items;
        calculateTax = new CalculateTax(items);
    }

    public void calculateBill() {
        calculateTax.calculateTotalPrice(items);
    }

    public double getSalesTax() {
        return calculateTax.getSalestax();
    }

    public double getTotalPrice() {
        return calculateTax.getTotalPrice();
    }



}


