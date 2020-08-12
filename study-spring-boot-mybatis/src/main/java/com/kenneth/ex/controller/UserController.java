package com.kenneth.ex.controller;

import com.kenneth.ex.entity.User;
import com.kenneth.ex.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Map<String, Object> findById(@Param("id") Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(User user) {
        return userService.insert(user);
    }
}
