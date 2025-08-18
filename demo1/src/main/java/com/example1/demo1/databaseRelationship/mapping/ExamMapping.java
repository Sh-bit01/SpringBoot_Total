package com.example1.demo1.databaseRelationship.mapping;

import com.example1.demo1.databaseRelationship.dto.ExamDTO;
import com.example1.demo1.databaseRelationship.model.ExamDetails;
import com.example1.demo1.databaseRelationship.model.StudentDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExamMapping {

    public ExamDTO toDTO(ExamDetails examDetails){
        List<Long> studentIds = examDetails.getStd()
                .stream()
                .map(StudentDetails::getId)
                .toList();

        return new ExamDTO(examDetails.getId(),
                examDetails.getSubject(),
                examDetails.getExamDate(),
                examDetails.getTotalMarks(),
                examDetails.getUserDetails().getId(),
                studentIds);
    }

//    public static ExamDetails toEntity(ExamDTO examDTO){
//        ExamDetails examDetails = new  ExamDetails();
//
//
//        return examDetails;
//    }




}
