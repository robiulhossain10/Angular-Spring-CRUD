package com.abc.AngularSpringCRUD.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class CourseDTO {
    private Long id;
    private String name;

private Set<Long> studentIds;
}
