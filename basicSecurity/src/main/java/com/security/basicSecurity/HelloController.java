package com.security.basicSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/user/hello")
    public String hello() {
        return "Hello, normal user!";
    }

    @GetMapping("/admin/hello")
    public String hello1() {
        return "Hello, admin user!";
    }
}
