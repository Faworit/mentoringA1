package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.UserDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDAOImpl implements UserDAO {
    @Autowired
    Storage storage;

   private Map<Long, User> users = storage.getUsers();

    @Override
    public User getUserById(long userId) {
        return users.get(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> user = users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(((p)-> p.getEmail().equals(email)))
                .collect(Collectors.toList());
        System.out.println(user.get(0));
        return user.get(0);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> user = users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(((p)-> p.getName().equals(name)))
                .collect(Collectors.toList());
        System.out.println(user.get(0));
        return user;
    }

    @Override
    public User createUser(User user) {
        long max = users.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        user.setId(key);
        users.put(key, user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        long key = user.getId();
        users.put(key, user);
        return user;
    }

    @Override
    public boolean deleteUser(long userId) {
        boolean deleteResult = false;
        users.remove(userId);
        if (users.get(userId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }
}
