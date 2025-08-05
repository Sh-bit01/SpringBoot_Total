package com.SG.SchoolManagementSystem.model;

import com.SG.SchoolManagementSystem.enumData.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;
import java.util.List;


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
    private String NAME;
    private String FATHER_NAME;
    private String MOTHER_NAME;
    //private String fatherName;
    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date DOB;
    private Date ADMISSION_DATE;
    private Gender GENDER;
    private String address;
    private BigInteger mobileNo;

    @Nullable
    private BigInteger secMobileNo;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;

    public int getUSER_ID() {
        return user.getId();
    }

//    public void setUSER_ID(int USER_ID) {
//        user.setId(USER_ID);
//    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grads;



    public void setUSER_ID(int userId) {
        user.setId(userId);    }
}
