package com.example1.demo1.crudDB.repo;

import com.example1.demo1.crudDB.model.CrudStudentsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<CrudStudentsDB, Integer> {
}
