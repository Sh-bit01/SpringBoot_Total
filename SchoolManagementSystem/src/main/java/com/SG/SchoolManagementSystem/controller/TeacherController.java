package com.SG.SchoolManagementSystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.SG.SchoolManagementSystem.service.TeacherService;

@Slf4j
@RestController
@RequestMapping("/staff/teacher/")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }


    @GetMapping("/getstd")
    public void getStudents(){


    }

    @PostMapping("/addstd")
    public void addStudents(){}

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
