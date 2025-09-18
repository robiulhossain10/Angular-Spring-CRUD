package com.abc.AngularSpringCRUD.service;

import com.abc.AngularSpringCRUD.dtos.DepartmentDTO;
import com.abc.AngularSpringCRUD.dtos.StudentDTO;
import com.abc.AngularSpringCRUD.entity.Course;
import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.entity.Student;
import com.abc.AngularSpringCRUD.repository.CourseRepository;
import com.abc.AngularSpringCRUD.repository.DepartmentRepository;
import com.abc.AngularSpringCRUD.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;


    //
//    public Student save(Student dept){
//        System.out.println("Repository save: " + dept.getFirstName());
//        return repository.save(dept);
//    }
//
    public List<Student> findAll() {
        return repository.findAll();
    }
//
//    public Optional<Student> FindById(Long id){
//        return repository.findById(id);
//    }
//
//    public void deleteById(Long id){
//        repository.deleteById(id);
//    }

    public StudentDTO getStudentById(Long id) {
        Optional<Student> st = repository.findById(id);

        StudentDTO std = new StudentDTO();
        st.ifPresent(student -> {
            BeanUtils.copyProperties(student, std);

            Set<Long> oldC = student.getCourses().stream().map(Course::getId).collect(Collectors.toSet());
        });

        return std;


    }


    public StudentDTO toDTO(Student student) {
        if (student == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirst_name(student.getFirstName());
        dto.setLast_name(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setDob(student.getDob());

        if (student.getDepartment() != null) {
            DepartmentDTO dp = new DepartmentDTO();
            dp.setId(student.getDepartment().getId());
            dp.setName(student.getDepartment().getName());
            dto.setDepartmentDTO(dp);
        }

        if (student.getCourses() != null) {
            dto.setCourseIds(student.getCourses().stream().map(Course::getId).collect(Collectors.toSet()));
        }

        return dto;


    }

    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

            Student st =  new Student();
            st.setId(studentDTO.getId());
            st.setFirstName(studentDTO.getFirst_name());
            st.setLastName(studentDTO.getLast_name());
            st.setEmail(studentDTO.getEmail());
            st.setDob(studentDTO.getDob());
            if (studentDTO.getDepartmentDTO() != null) {
                Department dp =
                        departmentRepository.findById(studentDTO.getDepartmentDTO().getId()).orElseThrow(
                        () -> new RuntimeException("Department not found"));
                dp.setId(studentDTO.getDepartmentDTO().getId());
                st.setDepartment(dp);
        }

            if (studentDTO.getCourseIds() != null &&  !studentDTO.getCourseIds().isEmpty()) {
                Set<Course> courses = new HashSet<>(courseRepository.findAllById(studentDTO.getCourseIds()));
                st.getCourses().clear();
                st.getCourses().addAll(courses);
            }

            return st;
    }


}
