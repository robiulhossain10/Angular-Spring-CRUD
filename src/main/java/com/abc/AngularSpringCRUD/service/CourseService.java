package com.abc.AngularSpringCRUD.service;

import com.abc.AngularSpringCRUD.dtos.CourseDTO;
import com.abc.AngularSpringCRUD.entity.Course;
import com.abc.AngularSpringCRUD.entity.Student;
import com.abc.AngularSpringCRUD.repository.CourseRepository;
import com.abc.AngularSpringCRUD.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
//    @Autowired
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Transactional
    // Create Course
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getName());

        if (courseDTO.getStudentIds() != null) {
            course.setStudents(new HashSet<>(studentRepository.findAllById(courseDTO.getStudentIds())));
        }

        Course saved = courseRepository.save(course);
        return mapToDTO(saved);
    }

    // Get All Courses
    public List<CourseDTO> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();

        return courseList
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get Course by ID
    public CourseDTO getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::mapToDTO).orElse(null);
    }

    // Update Course
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setCourseName(courseDTO.getName());


        if (courseDTO.getStudentIds() != null) {
            course.setStudents(new HashSet<>(studentRepository.findAllById(courseDTO.getStudentIds())));
        }

        return mapToDTO(courseRepository.save(course));
    }

    // Delete Course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Mapper: Entity -> DTO


    private CourseDTO mapToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getCourseName());

        if (course.getStudents() != null) {
            dto.setStudentIds(course.getStudents()
                    .stream()
                    .map(Student::getId)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }
}
