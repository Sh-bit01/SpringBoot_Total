package com.example1.demo1.databaseRelationship.service;


import com.example1.demo1.databaseRelationship.dto.StudentDto;
import com.example1.demo1.databaseRelationship.mapping.StudentMapping;
import com.example1.demo1.databaseRelationship.model.StudentDetails;
import com.example1.demo1.databaseRelationship.model.UserDetails;
import com.example1.demo1.databaseRelationship.repo.StudentsRepo;
import com.example1.demo1.databaseRelationship.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    private final UserRepo userRepo;
    private final StudentsRepo studentsRepo;
    private final StudentMapping studentMapping;

    @Autowired
    public DbService(UserRepo userRepo, StudentsRepo studentsRepo,
                     StudentMapping studentMapping) {
        this.userRepo = userRepo;
        this.studentsRepo = studentsRepo;
        this.studentMapping = studentMapping;
    }

    // user Details Operation
    public void addUser(UserDetails ud){
        userRepo.save(ud);
    }

    public List<UserDetails> getUser(){
        return userRepo.findAll();
    }




    // Students Details Operation
    public void addStudent(StudentDto sd) {
        StudentDetails stu = StudentMapping.toEntity(sd);
        studentsRepo.save(stu);
    }

    public List<StudentDto> getStudents(){
        return studentsRepo.findAll().stream().map(studentMapping::toDTO).toList();
    }

}
