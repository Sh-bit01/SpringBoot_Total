package com.example1.demo1.databaseRelationship.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String section;
    private String stu_class;
    private String remark;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails userDetails;

    @ManyToMany(mappedBy = "std")
    private ExamDetails exam;

}
