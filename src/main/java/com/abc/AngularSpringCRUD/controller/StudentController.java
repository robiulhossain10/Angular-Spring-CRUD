package com.abc.AngularSpringCRUD.controller;

import com.abc.AngularSpringCRUD.dtos.StudentDTO;
import com.abc.AngularSpringCRUD.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>>
    create(@Valid @RequestBody StudentDTO st){
        StudentDTO savedStudent = service.save(st);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Student created successfully");
        response.put("student", savedStudent);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/users")
    public List<StudentDTO> getAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable
        Long id, @Valid @RequestBody StudentDTO st){
        st.setId(id);
        return service.save(st);
    }

//    public ResponseEntity<Map <String, Object>> update(
//            @PathVariable Long id, @Valid @RequestBody StudentDTO st){
//        st.setId(id);
//        StudentDTO updateStudent = service.save(st);
//        Map<String,Object> response = new HashMap<>();
//        response.put("status","success");
//        response.put("message","Student Updated Successfully");
//        response.put("student", updateStudent);
//
//        return ResponseEntity.ok(response);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
