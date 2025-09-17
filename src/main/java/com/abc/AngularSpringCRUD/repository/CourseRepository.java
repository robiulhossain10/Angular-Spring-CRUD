package com.abc.AngularSpringCRUD.repository;

import com.abc.AngularSpringCRUD.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
