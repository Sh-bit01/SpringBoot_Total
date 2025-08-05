package com.SG.SchoolManagementSystem.mapper;

import com.SG.SchoolManagementSystem.dto.StudentDTO;
import com.SG.SchoolManagementSystem.model.Students;

public class StudentMapper {

    public static StudentDTO toDTO(Students student) {
        return new StudentDTO(
                student.getId(),
                student.getNAME(),
                student.getFATHER_NAME(),
                student.getMOTHER_NAME(),
                student.getDOB(),
                student.getADMISSION_DATE(),
                student.getGENDER(),
                student.getAddress(),
                student.getMobileNo(),
                student.getSecMobileNo(),
                student.getUSER_ID());
    }

    public static Students toEntity(StudentDTO dto) {
        Students student = new Students();
        student.setId(dto.getID());
        student.setNAME(dto.getNAME());
        student.setFATHER_NAME(dto.getFATHER_NAME());
        student.setMOTHER_NAME(dto.getMOTHER_NAME());
        student.setDOB(dto.getDOB());
        student.setADMISSION_DATE(dto.getADMISSION_DATE());
        student.setGENDER(dto.getGENDER());
        student.setMobileNo(dto.getMobileNo());
        student.setSecMobileNo(dto.getSecMobileNo());
        student.setUSER_ID(dto.getUSER_ID());
        return student;
    }





}
