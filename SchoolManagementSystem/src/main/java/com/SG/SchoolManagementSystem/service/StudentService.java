package com.SG.SchoolManagementSystem.service;


import com.SG.SchoolManagementSystem.model.Students;
import com.SG.SchoolManagementSystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo st;

    public List<Students> getAllStudents(){
        return st.findAll();
    }



}
