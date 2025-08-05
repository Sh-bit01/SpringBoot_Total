package com.SG.SchoolManagementSystem.service;


import com.SG.SchoolManagementSystem.dto.StudentDTO;
import com.SG.SchoolManagementSystem.mapper.StudentMapper;
import com.SG.SchoolManagementSystem.model.Students;
import com.SG.SchoolManagementSystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepo st;

    public List<StudentDTO> getAllStudents(){
        return st.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String addStudent(StudentDTO stu) {
        try {
            Students student = StudentMapper.toEntity(stu);
            st.save(student);
            return "Inserted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
