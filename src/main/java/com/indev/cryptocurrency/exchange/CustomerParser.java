package com.indev.cryptocurrency.exchange;

public class CustomerParser {

    public String parseCustomer(Customer customer){
        String displayCustomer =  customer.getBalance()+":$";
        if(customer.getCurrency()==null) return displayCustomer;
        if(!customer.getCurrency().getName().trim().isEmpty())
            displayCustomer+=","+customer.getQuantityCurrency()+":"+customer.getCurrency().getName();

        return displayCustomer;
    }


}
