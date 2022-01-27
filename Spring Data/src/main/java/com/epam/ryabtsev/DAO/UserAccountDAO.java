package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.UserAccount;
import com.epam.ryabtsev.model.impl.UserAccountImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountDAO extends CrudRepository<UserAccountImpl, Long> {
    UserAccountImpl findByUserId(long userId);
    UserAccountImpl findByAccountId(long accountId);
    boolean deleteById(long accountId);
}
