package com.abc.AngularSpringCRUD.repository;

import com.abc.AngularSpringCRUD.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
