package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/get")
    public String getUserById(@RequestParam long userId, Model model) {
        User user = bookingFacade.getUserById(userId);
        List<User> users = new ArrayList<>();
        users.add(user);
        model.addAttribute("users", users);

        return "user";
    }

    @GetMapping("/get/email")
    public String getByEmail(@RequestParam String email, Model model) {
        User user = bookingFacade.getUserByEmail(email);
        List<User> users = new ArrayList<>();
        users.add(user);
        model.addAttribute("users", users);
        return "user";

    }

    @GetMapping("/get/name/{userName}")
    public String getByUserName(@PathVariable String userName, Model model) {
        List<User> users = bookingFacade.getUsersByName(userName, 0, 0);
        model.addAttribute("users", users);

        return "user";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String name, @RequestParam String email, Model model) {
        User createUser = new UserImpl();
        createUser.setName(name);
        createUser.setEmail(email);
        User newUser = bookingFacade.createUser(createUser);
        List<User> users = new ArrayList<>();
        users.add(newUser);
        model.addAttribute("users", users);

        return "user";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam String name, @RequestParam String email, @RequestParam String id, Model model) {
        User user = new UserImpl();
        user.setId(Long.parseLong(id));
        user.setEmail(email);
        user.setName(name);
        User updatedUser = bookingFacade.updateUser(user);
        List<User> users = new ArrayList<>();
        users.add(updatedUser);
        model.addAttribute("users", users);

        return "user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam String id, Model model) {
        boolean result = bookingFacade.deleteUser(Long.parseLong(id));
        if (result) {
            model.addAttribute("result", "user with id: " + id + " was successfully deleted");
        } else {
            model.addAttribute("result", "user with id: " + id + " was not deleted");
        }
        return "index";
    }
}