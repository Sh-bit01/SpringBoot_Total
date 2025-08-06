package com.example1.demo1.databaseRelationship.model;

import com.example1.demo1.databaseRelationship.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    //login Info
    private String password;
    private String username;
    private String email;

    //User Info
    private String name;
    private String address;
    private String gender;
    private Role role;





}
