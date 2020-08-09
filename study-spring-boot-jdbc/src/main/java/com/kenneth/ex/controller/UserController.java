package com.kenneth.ex.controller;

import com.kenneth.ex.entity.User;
import com.kenneth.ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user) {
        return userService.addUser(user);
    }
}
