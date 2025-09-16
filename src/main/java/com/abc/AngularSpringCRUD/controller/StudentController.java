package com.abc.AngularSpringCRUD.controller;

import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.entity.Student;
import com.abc.AngularSpringCRUD.service.DepartmentService;
import com.abc.AngularSpringCRUD.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Student create(@Valid @RequestBody Student st){
        return service.save(st);
    }

    @GetMapping("/users")
    public List<Student> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return service.FindById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody Student st){
        st.setId(id);
        return service.save(st);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
