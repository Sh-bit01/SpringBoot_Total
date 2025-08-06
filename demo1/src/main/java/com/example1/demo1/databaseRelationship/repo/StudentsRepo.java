package com.example1.demo1.databaseRelationship.repo;

import com.example1.demo1.databaseRelationship.model.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<StudentDetails, Long> {
}
