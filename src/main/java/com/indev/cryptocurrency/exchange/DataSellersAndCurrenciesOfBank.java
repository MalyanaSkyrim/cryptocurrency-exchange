package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashMap;

public class DataSellersAndCurrenciesOfBank {

    HashMap<String, ArrayList<Customer>> sellersByCurrency = new HashMap<>();

    public void addCurrency(String currency) {
          sellersByCurrency.put(currency,new ArrayList<>());
    }

    public void addSeller(Customer sellerCustomer) {

        if(sellersByCurrency.containsKey(sellerCustomer.getCurrency().getName()))
                 sellersByCurrency.get(sellerCustomer.getCurrency().getName()).add(sellerCustomer);
        else {
            sellersByCurrency.put(sellerCustomer.getCurrency().getName(), new ArrayList<>());
            sellersByCurrency.get(sellerCustomer.getCurrency().getName()).add(sellerCustomer);
        }
    }
}
