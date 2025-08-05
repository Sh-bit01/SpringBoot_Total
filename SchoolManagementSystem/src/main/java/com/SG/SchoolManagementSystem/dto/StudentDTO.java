package com.SG.SchoolManagementSystem.dto;

import com.SG.SchoolManagementSystem.enumData.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Data
public class StudentDTO {
    public StudentDTO(int ID, String NAME, String FATHER_NAME,
                      String MOTHER_NAME, Date DOB, Date ADMISSION_DATE,
                      Gender GENDER, String address, BigInteger mobileNo,
                      BigInteger secMobileNo, int USER_ID) {
        this.ID = ID;
        this.NAME = NAME;
        this.FATHER_NAME = FATHER_NAME;
        this.MOTHER_NAME = MOTHER_NAME;
        this.DOB = DOB;
        this.ADMISSION_DATE = ADMISSION_DATE;
        this.GENDER = GENDER;
        this.address = address;
        this.mobileNo = mobileNo;
        this.secMobileNo = secMobileNo;
        this.USER_ID = USER_ID;
    }

    public StudentDTO(){}

    private int ID;
    private String NAME;
    private String FATHER_NAME;
    private String MOTHER_NAME;
    private Date DOB;
    private Date ADMISSION_DATE;
    private Gender GENDER;
    private String address;
    private BigInteger mobileNo;
    private BigInteger secMobileNo;
    private int USER_ID;

}
