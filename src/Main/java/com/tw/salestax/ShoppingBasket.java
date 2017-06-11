package com.tw.salestax;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    List<Item> items;
    SalesTax salesTax;
    String[] itemDetails;
    public static ArrayList<String> products = new ArrayList<>();

    ShoppingBasket(String[] itemDetails) {
        if(itemDetails==null){
            
        }
        this.itemDetails = itemDetails;
        items = new ArrayList<Item>();
        products = new ArrayList<>();
        new SalesTax(items);
    }

    public static void productsNotTaxable(){
        products.add("book");
        products.add("chocolate");
        products.add("pills");
    }

    public void createItem() {
        for (String string : itemDetails) {
            String[] recieveItem = string.split(" at ");
            double price = Double.parseDouble(recieveItem[recieveItem.length - 1]);
            String[] itemDetails = recieveItem[0].split(" ", 2);
            int quantity = Integer.parseInt(itemDetails[0]);
            String name = itemDetails[1];
            boolean isImported = name.contains("imported");
            items.add(new Item(name, quantity, price, isImported));
        }
    }

    List<Item> getItemList() {
        return items;
    }

}