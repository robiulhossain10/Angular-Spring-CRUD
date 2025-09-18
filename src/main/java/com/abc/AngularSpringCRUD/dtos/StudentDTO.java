package com.abc.AngularSpringCRUD.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class StudentDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate dob;

    private DepartmentDTO departmentDTO;

    private Set<Long> courseIds;
}
