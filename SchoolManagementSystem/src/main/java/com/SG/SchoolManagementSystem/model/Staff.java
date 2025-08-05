package com.SG.SchoolManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {

    @Id
    @SequenceGenerator(name = "Stid", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Stid")
    private int id;
    private String DESIGNATION;
    private String DEPARTMENT;
    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date JOINING_DATE;

    private BigInteger SALARY;
    private String SHIFT;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;
}
