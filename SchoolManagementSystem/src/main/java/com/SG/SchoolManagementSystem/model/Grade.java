package com.SG.SchoolManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;





}
