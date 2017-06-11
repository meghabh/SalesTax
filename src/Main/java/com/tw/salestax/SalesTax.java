package com.tw.salestax;

import java.util.List;

public class SalesTax {
    List<Item> items;
    double totalPrice, totalSalesTax;
    static final int IMPORTED_TAX_RATE = 5, BASE_TAX_RATE = 10;

    public SalesTax(List<Item> items) {
        totalPrice = 0.0;
        this.items=items;
    }

    public void calculateBill() {
        ShoppingBasket.productsNotTaxable();
        for (Item item : items) {
            double salestax=0.00;
            if (item.isImported())
                salestax = calculateSalesTax(IMPORTED_TAX_RATE, item.getPrice());
            if (isTaxApplicable(item.getName()))
                salestax += calculateSalesTax(BASE_TAX_RATE, item.getPrice());
            item.setPrice(item.getPrice() + salestax);
            item.setSalesTax(salestax);
            totalSalesTax = totalSalesTax + salestax;
            totalPrice = totalPrice + item.getPrice();
            totalPrice = Double.parseDouble(String.format("%.2f", totalPrice));
        }
    }

    public double calculateSalesTax(int taxrate, double shelfPriceOfItem) {
        double salesTax;
        salesTax = (taxrate * shelfPriceOfItem) / 100;
        salesTax = Math.round(salesTax * 20) / 20.0;
        return salesTax;
    }

    public boolean isTaxApplicable(String name) {
        for (String product : ShoppingBasket.products) {
            if (name.contains(product)) {
                return false;
            }
        }
        return true;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getSalesTax(){
        return totalSalesTax;
    }

    public double getTotalTax() {
        return totalSalesTax;
    }

    public List<Item> getItemList() {
        return items;
    }
}





