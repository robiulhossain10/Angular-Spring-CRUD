package com.abc.AngularSpringCRUD.service;

import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.entity.Student;
import com.abc.AngularSpringCRUD.repository.DepartmentRepository;
import com.abc.AngularSpringCRUD.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student save(Student dept){
        System.out.println("Repository save: " + dept.getFirstName());
        return repository.save(dept);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Optional<Student> FindById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
