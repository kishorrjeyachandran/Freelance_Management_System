package com.examly.springapp.controller;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.service.DepartmentService;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department saved = service.addDepartment(department);
        return ResponseEntity.created(URI.create("/api/departments/" + saved.getId())).body(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department updated = service.updateDepartment(id, department);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        Department dept = service.getDepartmentById(id);
        return ResponseEntity.ok(dept);
    }

    @GetMapping("/page/{offset}/{page}")
    public Page<Department> getDepartmentsPage(@PathVariable("offset") int page,@PathVariable("page") int size){
        Pageable pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    
}
