package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.UserAccount;
import com.epam.ryabtsev.model.impl.UserAccountImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountDAO extends JpaRepository<UserAccountImpl, Long> {
    UserAccountImpl getUserAccountImplByUserId(long userId);
    UserAccountImpl getUserAccountImplByAccountId(long accountId);
    void deleteByAccountId(long acoountId);

}
