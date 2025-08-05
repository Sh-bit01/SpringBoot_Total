package com.SG.SchoolManagementSystem.controller;

import com.SG.SchoolManagementSystem.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SG.SchoolManagementSystem.service.TeacherService;

import java.util.List;

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
