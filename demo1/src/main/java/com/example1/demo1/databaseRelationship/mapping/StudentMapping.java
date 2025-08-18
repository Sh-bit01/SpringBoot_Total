package com.example1.demo1.databaseRelationship.mapping;

import com.example1.demo1.databaseRelationship.dto.StudentDto;
import com.example1.demo1.databaseRelationship.model.StudentDetails;
import org.springframework.stereotype.Component;

@Component
public class StudentMapping {
    public StudentDto toDTO(StudentDetails studentDetails){
        return new StudentDto(
                studentDetails.getId(),
                studentDetails.getSection(),
                studentDetails.getStu_class(),
                studentDetails.getRemark(),
                studentDetails.getUserDetails().getId());
    }

    public static StudentDetails toEntity(StudentDto studentDto){
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(studentDto.getId());
        studentDetails.setRemark(studentDto.getRemark());
        studentDetails.setSection(studentDto.getSection());
        return studentDetails;
    }
}
