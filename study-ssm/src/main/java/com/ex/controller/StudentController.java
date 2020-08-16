package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ex")
public class StudentController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    @ResponseBody
    public String sayHello() {
        return "hello";
    }
}
