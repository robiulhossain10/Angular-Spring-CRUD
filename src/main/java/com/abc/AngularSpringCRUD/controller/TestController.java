package com.abc.AngularSpringCRUD.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class TestController {


    @Value("${profile}")
    private String message;

    @GetMapping("/")
    public String home (){
        return "Profile-Name : " + message;
    }
}
