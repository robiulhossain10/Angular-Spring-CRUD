package com.abc.AngularSpringCRUD.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;

    private List<StudentDTO> students;
}
