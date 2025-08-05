package com.SG.SchoolManagementSystem.repo;

import com.SG.SchoolManagementSystem.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {
}
