package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/get/{userId}")
    public String getUserById(@PathVariable long userId, Model model) {
        User user = bookingFacade.getUserById(userId);
        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping("/get/email/{email}")
    public String getByEmail(@PathVariable String email, Model model) {
        User user = bookingFacade.getUserByEmail(email);
        model.addAttribute("user", user);
        return "user";

    }

    @GetMapping("/get/name/{userName}")
    public String getByUserName(@PathVariable String userName, Model model) {
        List<User> users = bookingFacade.getUsersByName(userName, 0, 0);
        model.addAttribute("users", users);

        return "user";
    }

    @PostMapping("/create")
    public String createUser(User user, Model model) {
        User newUser = bookingFacade.createUser(user);
        model.addAttribute("user", newUser);

        return "user";
    }

    @PostMapping("update")
    public String updateUser(User user, Model model) {
        User updatedUser = bookingFacade.updateUser(user);
        model.addAttribute("user", updatedUser);

        return "user";
    }

    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable long userId, Model model) {
        boolean result = bookingFacade.deleteUser(userId);
        if (result) {
            model.addAttribute("result", "user with id: " + userId + " was successfully deleted");
        } else {
            model.addAttribute("result", "user with id: " + userId + " was not deleted");
        }

        return "actionResult";
    }
}
