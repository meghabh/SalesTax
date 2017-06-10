package com.tw.salestax;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculateTax {
    String[] items;
    ArrayList<String>  itemList;
    CalculateTax(String[] items){
        this.items=items;
        itemList=new ArrayList<>();
    }
    public void calculateTotalPrice() {
        for (String string:items) {
            String[] recieveditems = string.split(" at ");
            String recievedItem = recieveditems[0] + " - " +recieveditems[recieveditems.length-1] ;
            System.out.println(recievedItem);
            itemList.add(recievedItem);
        }

    }

    public ArrayList<String> getReciept() {
        return itemList;
    }
}
