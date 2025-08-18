package com.example1.demo1.controller;


import com.example1.demo1.databaseRelationship.dto.StudentDto;
import com.example1.demo1.databaseRelationship.model.UserDetails;
import com.example1.demo1.databaseRelationship.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2")
public class DbRelationshipController {

    private final DbService dbService;

    @Autowired
    public DbRelationshipController(DbService dbService) {
        this.dbService = dbService;
    }

    // User Controller

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDetails ud){
        dbService.addUser(ud);
        return "inserted";
    }

    @GetMapping("/getUser")
    public Optional<List<UserDetails>> getUserDetails(){
        return Optional.ofNullable(dbService.getUser());
    }


    // Student Controller

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDto sd){
        dbService.addStudent(sd);
        return "inserted";
    }

    @GetMapping("/getStudent")
    public Optional<List<StudentDto>> getStudentDetails(){
        return Optional.ofNullable(dbService.getStudents());
    }






}
