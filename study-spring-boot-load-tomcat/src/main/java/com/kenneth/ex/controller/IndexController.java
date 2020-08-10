package com.kenneth.ex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/indexController")
    private String indexController() {
        return "indexController";
    }

}
