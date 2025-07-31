package controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TeacherService;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    TeacherService ts;

    @PostMapping("/login")
    public void login(){
    
    }

    @PostMapping("/logout")
    public void logout(){

    }

    @PostMapping("/reset")
    public void resetPass(){

    }

    @PostMapping("/register")
    public void register(){

    }


}
