package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.UserDAO;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.UserImpl;
import com.epam.ryabtsev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    public UserServiceImpl() {
    }

    @Override
    public User getUserById(long userId) {

        return userDAO.getUserImplById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserImplByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        Pageable pageable = (Pageable) PageRequest.of(pageNum, pageSize);
        return userDAO.getUserImplByName(name);
    }

    @Override
    public User createUser(User user) {
        return userDAO.save((UserImpl) user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.save((UserImpl) user);
    }

    @Override
    public boolean deleteUser(long userId) {
        boolean result;
        try {
            userDAO.getUserImplById(userId);
            result = true;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
}
