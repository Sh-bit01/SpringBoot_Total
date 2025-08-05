package com.SG.SchoolManagementSystem.model;

import com.SG.SchoolManagementSystem.enumData.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class UserDetails {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private int id;

    @Column(unique = true, nullable = false)
    private String username;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @Column(nullable = true)
    private String oldPassword;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Students student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Staff staff;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private  Profile profile;

}

