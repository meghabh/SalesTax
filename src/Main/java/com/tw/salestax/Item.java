package com.tw.salestax;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private boolean isImported;
    private double salesTax;

    Item(String name, int quantity, double price, boolean isImported) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setImported(isImported);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }
}

