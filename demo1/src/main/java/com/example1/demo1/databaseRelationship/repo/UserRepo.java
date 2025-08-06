package com.example1.demo1.databaseRelationship.repo;

import com.example1.demo1.databaseRelationship.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDetails, Long> {
}
