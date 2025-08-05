package com.SG.SchoolManagementSystem.controller;

import com.SG.SchoolManagementSystem.dto.StudentDTO;
import com.SG.SchoolManagementSystem.model.Students;
import com.SG.SchoolManagementSystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.SG.SchoolManagementSystem.service.TeacherService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/staff/teacher/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService stuSer;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }


    @GetMapping("/getstd")
    public List<StudentDTO> getStudents(){
        return stuSer.getAllStudents();
    }

    @PostMapping("/addstd")
    public String addStudents(@RequestBody StudentDTO st){
        return  stuSer.addStudent(st);
    }

    @DeleteMapping("/removestd")
    public void delStudent(){}

    @PostMapping("/updatestd")
    public void updateStudent(){}

    @PostMapping("/attendence")
    public void attendance(){}

    @PostMapping("/FetchA")
    public void fetchAttendance(){}

    @PostMapping("/addnotice")
    public void addNotice(){}

    @PostMapping("/editnotice")
    public void editNotice(){}

    @PostMapping("/delnotice")
    public void delNotice(){}

}
