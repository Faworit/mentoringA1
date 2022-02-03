package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.UserAccount;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class UserAccountImpl implements UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountId;
    private BigDecimal balance;
    @OneToOne(mappedBy = "userAccount")
    private UserImpl user;


    @Override
    public long getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(long id) {
        this.accountId = id;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public UserImpl getUser() {
        return user;
    }

    @Override
    public void setUser(UserImpl user) {
        this.user = user;
    }
}
