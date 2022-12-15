package com.example.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testcontroller {

    @RequestMapping("/test1")
    public String testController(){
        return "test";
    }
}
