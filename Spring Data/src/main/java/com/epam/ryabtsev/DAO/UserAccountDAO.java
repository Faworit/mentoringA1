package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.UserAccount;
import com.epam.ryabtsev.model.impl.UserAccountImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountDAO extends CrudRepository<UserAccountImpl, Long> {
    UserAccountImpl getUserAccountImplByUserId(long userId);
    UserAccountImpl getUserAccountImplByAccountId(long accountId);
    boolean deleteByAccountId(long accountId);
}
