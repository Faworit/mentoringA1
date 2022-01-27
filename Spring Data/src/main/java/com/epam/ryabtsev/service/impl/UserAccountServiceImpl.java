package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.UserAccountDAO;
import com.epam.ryabtsev.model.UserAccount;
import com.epam.ryabtsev.model.impl.UserAccountImpl;
import com.epam.ryabtsev.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    UserAccountDAO userAccountDAO;

    @Override
    public UserAccount createUserAccount(UserAccountImpl userAccount) {
        long id = userAccountDAO.save(userAccount).getAccountId();
        userAccount.setAccountId(id);
        return userAccount;
    }

    @Override
    public UserAccount refillUserAccount(BigDecimal balance, long userId) {
        UserAccountImpl userAccount = userAccountDAO.findByUserId(userId);
        userAccount.setBalance(balance);
        userAccountDAO.save(userAccount);
        return userAccount;
    }

    @Override
    public UserAccount getUserAccount(long userAccountId) {
        return userAccountDAO.findByAccountId(userAccountId);
    }

    @Override
    public boolean deleteUserAccount(long userAccountId) {

        return userAccountDAO.deleteById(userAccountId);
    }
}
