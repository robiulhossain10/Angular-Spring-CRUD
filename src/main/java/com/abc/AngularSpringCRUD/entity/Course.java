package com.abc.AngularSpringCRUD.entity;

import com.abc.AngularSpringCRUD.config.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Course extends BaseEntity {
    private String courseName;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students =  new HashSet<>();
}
