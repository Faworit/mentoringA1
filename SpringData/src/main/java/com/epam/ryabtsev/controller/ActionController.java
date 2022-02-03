package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/action")
public class ActionController {

    @GetMapping("create")
    public String create() {
        return "addUser";
    }

    @GetMapping("createEvent")
    public String createEvent() {
        return "newEvent";
    }

    @PostMapping("/update")
    public String update(@RequestParam long id, @RequestParam String name, @RequestParam String email, Model model) {
        User user = new UserImpl();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        model.addAttribute("user", user);
        return "updateUser";
    }
}
