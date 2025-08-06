package com.example1.demo1.databaseRelationship.service;


import com.example1.demo1.databaseRelationship.model.StudentDetails;
import com.example1.demo1.databaseRelationship.model.UserDetails;
import com.example1.demo1.databaseRelationship.repo.StudentsRepo;
import com.example1.demo1.databaseRelationship.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    private final UserRepo userRepo;
    private final StudentsRepo studentsRepo;

    @Autowired
    public DbService(UserRepo userRepo, StudentsRepo studentsRepo) {
        this.userRepo = userRepo;
        this.studentsRepo = studentsRepo;
    }

    // user Details Operation
    public void addUser(UserDetails ud){
        userRepo.save(ud);
    }

    public List<UserDetails> getUser(){
        return userRepo.findAll();
    }




    // Students Details Operation
    public void addStudent(StudentDetails sd) {
        studentsRepo.save(sd);
    }

    public List<StudentDetails> getStudents(){
        return studentsRepo.findAll();
    }

}
