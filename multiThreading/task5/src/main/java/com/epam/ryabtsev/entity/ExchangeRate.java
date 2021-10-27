package com.epam.ryabtsev.entity;

import java.util.concurrent.ConcurrentHashMap;

public class ExchangeRate {
    private static ConcurrentHashMap<CurrencyType, Currency> exchangeRate = new ConcurrentHashMap<>();

    public void addCurrency(Currency currency) {
        exchangeRate.put(currency.getType(), currency);
    }


}
