package com.SG.SchoolManagementSystem.repo;

import com.SG.SchoolManagementSystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {
}
