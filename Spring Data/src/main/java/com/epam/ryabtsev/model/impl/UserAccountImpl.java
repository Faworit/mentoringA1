package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.UserAccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccountImpl implements UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountId;
    private long balance;
    private long userId;


    @Override
    public long getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(long id) {
        this.accountId = id;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
