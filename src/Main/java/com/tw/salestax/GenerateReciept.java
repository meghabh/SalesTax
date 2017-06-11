package com.tw.salestax;

import java.util.ArrayList;
import java.util.List;

public class GenerateReciept {
    private SalesTax salesTax;
    List<Item> items;
    ArrayList<String> reciept;

    public GenerateReciept(List<Item> items, SalesTax salesTax) {
        this.items = items;
        reciept = new ArrayList<>();
        this.salesTax = salesTax;
    }

    public void createReciept() {
        for (Item item : items) {
            reciept.add(item.getQuantity() + " " + item.getName() + " - " + item.getPrice());
            System.out.println(reciept);
        }
        reciept.add("Sales Taxes - " + salesTax.getTotalTax());
        reciept.add("Total - " + salesTax.getTotalPrice());
    }

    public ArrayList<String> getReceipt() {
        return reciept;
    }
}
