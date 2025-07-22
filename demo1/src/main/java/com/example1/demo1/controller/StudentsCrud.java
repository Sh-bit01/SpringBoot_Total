package com.example1.demo1.controller;

import com.example1.demo1.crud.model.StudentsDB;
import com.example1.demo1.crud.service.StudentsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsCrud {

    @Autowired
    StudentsData Student;

    @GetMapping("/students")
    List<StudentsDB> getStudentData(){
        return Student.getAllData();
    }

    @GetMapping("/student/{rollno}")
    StudentsDB getStudentByRoll(@PathVariable int rollno){
        System.out.println(rollno);
        return Student.getStudentByRollNo(rollno);
    }

    @GetMapping("/student")
    StudentsDB getStudentByRollReq(@RequestParam int rollno){
        System.out.println(rollno);
        return Student.getStudentByRollNo(rollno);
    }

    @PostMapping("/student")
    String addDataInStudentDB(@RequestBody StudentsDB student){
        Student.addDataInStudent(student);
        return "inserted";
    }

    @DeleteMapping("/student")
    String removeDataFromStudentDB(@RequestParam int rollno){
        return Student.removeDataFromStudent(rollno);
    }

    @PutMapping("/update")
    String updateStudentDB(@RequestParam int rollno, @RequestBody StudentsDB student){

        return Student.updateStudentDB(rollno, student);
    }

}
