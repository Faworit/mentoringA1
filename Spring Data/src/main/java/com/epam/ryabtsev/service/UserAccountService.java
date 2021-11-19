package com.epam.ryabtsev.service;

import com.epam.ryabtsev.model.UserAccount;
import com.epam.ryabtsev.model.impl.UserAccountImpl;

import java.util.List;

public interface UserAccountService {
    UserAccount createUserAccount(UserAccountImpl userAccount);
    UserAccount refillUserAccount(long sum, long userId);
    UserAccount getUserAccount(long userAccountId);
    boolean deleteUserAccount(long userAccountId);
}
