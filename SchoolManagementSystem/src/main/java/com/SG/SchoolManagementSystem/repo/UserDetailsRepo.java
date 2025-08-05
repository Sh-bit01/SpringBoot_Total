package com.SG.SchoolManagementSystem.repo;

import com.SG.SchoolManagementSystem.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {
}
