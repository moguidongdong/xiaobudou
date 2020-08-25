package com.ex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThymeleafTestController {

    @RequestMapping("/thymeleaf")
    public String toThymeleaf() {
        return "thymeleaf";
    }
}
