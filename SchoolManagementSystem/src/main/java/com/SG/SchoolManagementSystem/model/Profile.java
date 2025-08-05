package com.SG.SchoolManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {

    @Id
    @SequenceGenerator(name = "Pid", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Pid")
    private int id;

    private String name;
    private String rollNo;
    private String regNo;
    private String fatherName;
    private String motherName;
    private String mobileNo;
    private String email;
    private String address;



    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;
}
