package com.indev.cryptocurrency.exchange;


import java.util.ArrayList;
import java.util.Observable;


public class SaleOperation extends Observable {

    private DataSellersAndCurrenciesOfBank dataSellersAndCurrenciesOfBank;
    private Customer buyerCustomer;
    private Currency currency;
    private int quantityToBuy;
    private static int countBuyers = 1;



    public SaleOperation(DataSellersAndCurrenciesOfBank dataSellersAndCurrenciesOfBank) {
        this.dataSellersAndCurrenciesOfBank = dataSellersAndCurrenciesOfBank;
        this.currency = new Currency();
        addObserver(this.currency);
    }

    public SaleOperation setBuyerCustomer(Customer buyerCustomer) {

        this.buyerCustomer = buyerCustomer;
        return this;
    }

    public SaleOperation setCurrencyToBuy(String currency) {
        this.currency.setName(currency);

        return this;
    }

    public void setQuantityToBuy(int quantityToBuy) {
        this.quantityToBuy = quantityToBuy;
    }

    public int doTransaction() {
        ArrayList<Customer> sellers = getSellers();
        if(sellers==null || sellers.size()==0) return 0;
        int quantityCurrency = sellers.get(0).getQuantityCurrency();
        if(quantityCurrency-quantityToBuy<=0) return 0;
        buyerCustomer.setCurrency(currency,quantityToBuy)
                     .reduceBalance(currency.getPrice()*quantityToBuy);

        sellers.get(0).setCurrency(currency,quantityCurrency-quantityToBuy)
                      .augmentBalance(currency.getPrice()*quantityToBuy);

        countBuyers++;
        setChanged();
        notifyObservers(countBuyers);

        return quantityToBuy;
    }



    private ArrayList<Customer> getSellers(){
        return dataSellersAndCurrenciesOfBank.sellersByCurrency.get(currency.getName());


    }



}