package com.tw.salestax;

import java.util.ArrayList;

public class Item {
    String name;
    int quantity;
    double price;
    boolean isImported;

    Item(String name, int quantity, double price, boolean isImported) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
    }

}

