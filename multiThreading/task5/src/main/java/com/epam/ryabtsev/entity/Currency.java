package com.epam.ryabtsev.entity;

public class Currency {
    private CurrencyType type;
    private Double sellRate;
    private Double buyRate;

    public Currency(CurrencyType type, Double sellRate, Double buyRate) {
        this.type = type;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }

    public CurrencyType getType() {
        return type;
    }

    public Double getSellRate() {
        return sellRate;
    }

    public Double getBuyRate() {
        return buyRate;
    }
}
