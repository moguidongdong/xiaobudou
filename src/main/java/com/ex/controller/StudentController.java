package com.ex.controller;

import com.ex.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController("StudentController")
@RequestMapping("/ex")
public class StudentController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    public String sayHello() {
        return "hello";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Student student) {
        return "save";
    }
}
