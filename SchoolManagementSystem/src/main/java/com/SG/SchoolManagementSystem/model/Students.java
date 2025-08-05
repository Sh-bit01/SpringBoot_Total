package com.SG.SchoolManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {

    @Id
    @SequenceGenerator(name = "Sid", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Sid")
    private int id;

    private String name;
    private String fatherName;
    private String address;
    private BigInteger mobileNo;

    @Nullable
    private BigInteger secMobileNo;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;
}
