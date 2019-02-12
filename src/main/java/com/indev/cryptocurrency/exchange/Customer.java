package com.indev.cryptocurrency.exchange;


public class Customer {

    private Currency currency;
    private int balance=0;
    private int quantityCurrency=0;

    public Customer withCryptocurrency(String currency, int quantityCurrency) {
        this.currency = new Currency();
        this.currency.setName(currency);
        this.quantityCurrency = quantityCurrency;
        return this;
    }

    @Override
    public String toString() {
        return new CustomerParser().parseCustomer(this);
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getBalance() {
        return balance;
    }

    public void reduceBalance(int balance){
        this.balance -= balance;
    }
    public  void augmentBalance(int balance){
        this.balance += balance;
    }

    public Customer setCurrency(Currency currency,int quantityCurrency){
        if( this.currency==null) this.currency = currency;
        if(this.currency.getName().equals(currency.getName()))
            this.quantityCurrency = quantityCurrency;
        else
            this.quantityCurrency += quantityCurrency;



        return this;
    }

    public int getQuantityCurrency() {
        return quantityCurrency;
    }


}
