package com.examly.springapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {
    @Autowired
    private final JobPositionService service;

    public JobPositionController(JobPositionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition job) {
        JobPosition saved = service.addJobPosition(job);
        return ResponseEntity.created(URI.create("/api/jobpositions/" + saved.getPositionId())).body(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition job) {
        JobPosition updated = service.updateJobPosition(id, job);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public List<JobPosition> getAll() {
        return service.getAllJobPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getById(@PathVariable Long id) {
        JobPosition dept = service.getJobPositionById(id);
        return ResponseEntity.ok(dept);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<JobPosition>> searchJobPositions(@PathVariable String keyword){
        List<JobPosition> result = service.searchJobPositions(keyword);
        return ResponseEntity.ok(result);
    }
}
