package com.abc.AngularSpringCRUD.controller;

import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Department create(@Valid @RequestBody Department dept) {
        return service.save(dept);
    }

    @PostMapping("/test/{id}")
    public String testcreate(@Valid @PathVariable Long id, @RequestBody Department dept, @RequestParam(name = "test" )  String get) {
        System.out.println("id : " + id);
        System.out.println(dept.toString());
        System.out.println(get);
        return "";
    }

    @GetMapping("/users")
    public List<Department> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.FindById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @Valid @RequestBody Department dept) {
        dept.setId(id);
        return service.save(dept);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


}
