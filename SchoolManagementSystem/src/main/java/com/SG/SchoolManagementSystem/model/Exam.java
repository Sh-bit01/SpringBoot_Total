package com.SG.SchoolManagementSystem.model;

import com.SG.SchoolManagementSystem.enumData.ExamType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exam {

    @Id
    private int id;
    private ExamType EXAM_TYPE;

    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date DATE;
    private int TOTAL_MARKS;





}
