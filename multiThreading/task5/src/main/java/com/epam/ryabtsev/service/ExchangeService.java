package com.epam.ryabtsev.service;

import com.epam.ryabtsev.entity.CurrencyType;

import java.math.BigDecimal;

public class ExchangeService {

    public BigDecimal exchangeCurrency(CurrencyType sell, CurrencyType buy, BigDecimal countSell) {
        BigDecimal result = BigDecimal.valueOf(4);

        return result;
    }
}
