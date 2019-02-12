package com.indev.cryptocurrency.exchange;


import java.util.Observable;
import java.util.Observer;

public class Currency implements Observer {

    private String name;
    private int price = 1;


    public Currency() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }






    @Override
    public void update(Observable o, Object countBuyers) {

        int numberBuyers = (int)countBuyers;
        price = numberBuyers*numberBuyers - numberBuyers;
        if(price==0) price=1;

    }
}
