package com.example1.demo1.crudDB.service;


import com.example1.demo1.crudDB.model.CrudStudentsDB;
import com.example1.demo1.crudDB.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBStudentData {

    //temp
    @Autowired
    StudentRepo Student;

    public List<CrudStudentsDB> getAllData(){
        return Student.findAll();
    }


    public CrudStudentsDB getStudentByRollNo(int rollno){
        return Student.findById(rollno).orElse(new CrudStudentsDB(0, "error", 0));
    }

    public void addDataInStudent(CrudStudentsDB student) {
        Student.save(student);
    }

    public String removeDataFromStudent(int rollno){
        Student.deleteById(rollno);
        return "deleted";
    }

    public CrudStudentsDB updateStudentDB(int rollno, CrudStudentsDB student){
        return Student.findById(rollno).map(user -> {
            user.setName(student.getName());
            user.setAge(student.getAge());
            return Student.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

