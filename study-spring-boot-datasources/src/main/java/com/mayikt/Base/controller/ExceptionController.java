package com.mayikt.Base.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> exceptionHandler() {
        Map<String, String> map = new HashMap<>();
        map.put("respMsg", "系统错误");
        map.put("respCode", "200");
        return map;
        //返回自定义的一错误页面
    }

}
