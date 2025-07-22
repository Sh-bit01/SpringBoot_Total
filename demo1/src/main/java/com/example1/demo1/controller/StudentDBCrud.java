package com.example1.demo1.controller;

import com.example1.demo1.crudDB.model.CrudStudentsDB;
import com.example1.demo1.crudDB.repo.StudentRepo;
import com.example1.demo1.crudDB.service.DBStudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db")
public class StudentDBCrud {

    @Autowired
    DBStudentData Student;

    @GetMapping("/students")
    List<CrudStudentsDB> getStudentData(){
        return Student.getAllData();
    }

    @GetMapping("/student/{rollno}")
    CrudStudentsDB getStudentByRoll(@PathVariable int rollno){
        System.out.println(rollno);
        return Student.getStudentByRollNo(rollno);
    }

    @GetMapping("/student")
    CrudStudentsDB getStudentByRollReq(@RequestParam int rollno){
        System.out.println(rollno);
        return Student.getStudentByRollNo(rollno);
    }

    @PostMapping("/student")
    String addDataInStudentDB(@RequestBody CrudStudentsDB student){
        System.out.println(student.toString());
        Student.addDataInStudent(student);
        return "inserted";
    }

    @DeleteMapping("/student")
    String removeDataFromStudentDB(@RequestParam int rollno){
        Student.removeDataFromStudent(rollno);
        return "deleted";
    }

    @PutMapping("/update")
    String updateStudentDB(@RequestParam int rollno, @RequestBody CrudStudentsDB student) {
        System.out.println(rollno);
        System.out.println(student.toString());
    Student.updateStudentDB(rollno,student);
        return "updated";
    }


}
