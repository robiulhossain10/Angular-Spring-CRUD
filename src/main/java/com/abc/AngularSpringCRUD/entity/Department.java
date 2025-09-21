package com.abc.AngularSpringCRUD.entity;

import com.abc.AngularSpringCRUD.config.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true,onlyExplicitlyIncluded = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments",
uniqueConstraints =
@UniqueConstraint(name = "UK_DEPARTMENT_NAME", columnNames = {"name"}))
public class Department extends BaseEntity {
    @NotBlank(message = "Department Name is Required")
    @Size(min = 3, max = 121)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("department")
    private List<Student> students;
}
