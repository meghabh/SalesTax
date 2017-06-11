package com.tw.salestax;

import java.util.List;

public class CalculateTax {
    List<Item> items;
    double totalPrice = 0.0, shelfPriceOfItem, salestax, totalSalesTax;
    int importedTaxRate = 5, taxRate = 10;

    public CalculateTax(List<Item> items) {
        this.items=items;
    }

    public void calculateTotalPrice(List<Item> items) {
        ShoppingBasket.productsNotTaxable();
        for (Item item : items) {
            salestax=0.00;
            if (item.isImported)
                salestax = calculateSalesTax(5, item.price);
            if (isTaxApplicable(item.name))
                salestax = calculateSalesTax(10, item.price);
            item.price = Double.parseDouble(String.format("%.2f",(item.price + salestax)));
            totalSalesTax = totalSalesTax + salestax;
            totalPrice = totalPrice + item.price;
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

    public double getSalestax() {
        return salestax;
    }
}





