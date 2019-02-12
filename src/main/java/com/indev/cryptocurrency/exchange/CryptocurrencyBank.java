package com.indev.cryptocurrency.exchange;

public class CryptocurrencyBank {

    private SaleOperation saleOperation;
    private DataSellersAndCurrenciesOfBank dataSellersAndCurrenciesOfBank;


    public CryptocurrencyBank(){
        dataSellersAndCurrenciesOfBank = new DataSellersAndCurrenciesOfBank();
        saleOperation = new SaleOperation(dataSellersAndCurrenciesOfBank);
    }

    public void addSupportedCryptoCurrency(String currency) {

        dataSellersAndCurrenciesOfBank.addCurrency(currency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantityToBuy, String currency) {

        saleOperation.setBuyerCustomer(buyerCustomer).setCurrencyToBuy(currency)
                .setQuantityToBuy(quantityToBuy);

        return saleOperation.doTransaction();
    }

    public void addSeller(Customer sellerCustomer) {
        dataSellersAndCurrenciesOfBank.addSeller(sellerCustomer);
    }
}
