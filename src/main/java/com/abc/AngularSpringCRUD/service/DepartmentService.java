package com.abc.AngularSpringCRUD.service;

import com.abc.AngularSpringCRUD.entity.Department;
import com.abc.AngularSpringCRUD.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Department save(Department dept){
        return repository.save(dept);
    }

    public List<Department> findAll(){
        return repository.findAll();
    }

    public Optional<Department> FindById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
         repository.deleteById(id);
    }

}
