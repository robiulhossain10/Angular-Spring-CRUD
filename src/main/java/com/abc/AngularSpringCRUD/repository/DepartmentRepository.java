package com.abc.AngularSpringCRUD.repository;

import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long> {
    Optional<Department> findByName(String name);
}
