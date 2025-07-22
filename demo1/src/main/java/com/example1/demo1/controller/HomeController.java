package com.example1.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

@GetMapping("/")
    String home(){
    return "i am Home";
}

    @GetMapping("/about")
    String about(){
        return "i am about";
    }

    @GetMapping("/error")
    String error(){
    return "error";
    }

}
