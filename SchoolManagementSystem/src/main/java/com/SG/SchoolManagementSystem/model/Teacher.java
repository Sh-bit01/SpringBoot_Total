package com.SG.SchoolManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    @Id
    @SequenceGenerator(name = "Tid", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Tid")
    private int id;

    private String name;
    private String section;
    private String shift;

    private String QUALIFICATION;

    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date JOINING_DATE;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;
    
}
