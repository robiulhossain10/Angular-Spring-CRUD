package com.abc.AngularSpringCRUD.controller;

import com.abc.AngularSpringCRUD.dtos.CourseDTO;
import com.abc.AngularSpringCRUD.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<CourseDTO> getAllCourse(){
        return courseService.getAllCourses();
    }

    @PostMapping("/create")
    public CourseDTO create(@RequestBody CourseDTO courseDTO){
        return courseService.createCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO courseDTO){
        courseDTO.setId(id);
        return courseService.updateCourse(id,courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
