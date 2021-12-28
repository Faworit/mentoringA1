package com.epam.ryabtsev.model;

import com.epam.ryabtsev.model.impl.UserImpl;

import java.math.BigDecimal;

public interface UserAccount {

    long getAccountId();
    void setAccountId(long id);
    BigDecimal getBalance();
    void setBalance(BigDecimal account);
    UserImpl getUser();
    void setUser(UserImpl user);
}
