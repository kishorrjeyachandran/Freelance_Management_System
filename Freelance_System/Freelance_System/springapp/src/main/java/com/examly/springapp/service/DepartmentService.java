package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department updatedDept) {
    return repository.findById(id).map(existing -> {
        existing.setDepartmentName(updatedDept.getDepartmentName());
        existing.setContactEmail(updatedDept.getContactEmail());
        existing.setContactPhone(updatedDept.getContactPhone());
        return repository.save(existing);
    }).orElse(null);
}

}
