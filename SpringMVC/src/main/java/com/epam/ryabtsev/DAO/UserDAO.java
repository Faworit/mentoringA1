package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<UserImpl, Long> {
    UserImpl getUserImplById(long userId);
    UserImpl getUserImplByEmail(String email);
    List<User> getUserImplByName(String name);
    void deleteById(Long userId);
}
