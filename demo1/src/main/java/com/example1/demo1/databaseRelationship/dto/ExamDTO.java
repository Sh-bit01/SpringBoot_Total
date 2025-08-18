package com.example1.demo1.databaseRelationship.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {

    private Long id;
    private String subject;
    private LocalDate examDate;
    private int totalMarks;
    private Long user_id;
    private List<Long> std_Id;
}
