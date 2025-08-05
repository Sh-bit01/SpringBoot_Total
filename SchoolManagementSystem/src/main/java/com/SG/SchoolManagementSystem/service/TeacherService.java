package com.SG.SchoolManagementSystem.service;

import com.SG.SchoolManagementSystem.model.Teacher;
import com.SG.SchoolManagementSystem.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    ExamRepo ex;
    @Autowired
    ProfileRepo pro;
    @Autowired
    StaffRepo Str;
    @Autowired
    StudentRepo sr;
    @Autowired
    TeacherRepo tr;
    @Autowired
    UserDetailsRepo udr;
    
    
    public String getdtd(){
        return "Hii ";
    }
}
