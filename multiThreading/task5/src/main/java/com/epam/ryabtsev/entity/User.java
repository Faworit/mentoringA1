package com.epam.ryabtsev.entity;

import java.math.BigDecimal;
import java.util.Map;

public class User {
    private String userName;
    private Map<CurrencyType, BigDecimal> money;
}
