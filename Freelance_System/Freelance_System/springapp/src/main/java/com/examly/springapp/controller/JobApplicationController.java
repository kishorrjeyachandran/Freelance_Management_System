package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class JobApplicationController {

    private final Map<Long, String> jobApplications = new HashMap<>();

    @PostMapping("/job-applications")
    public ResponseEntity<String> create(@RequestBody(required = false) String body) {
        if (body == null) {
            return ResponseEntity.badRequest().body("Request body required");
        }

        long id = jobApplications.size() + 1;
        jobApplications.put(id, body);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Created ID: " + id);
    }

    @GetMapping("/job-applications")
    public ResponseEntity<Object> getAll() {

        if (jobApplications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(jobApplications);
    }

    @GetMapping("/job-applications/{id}")
    public ResponseEntity<String> getById(@PathVariable long id) {
        if (!jobApplications.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job application not found");
        }

        return ResponseEntity.ok(jobApplications.get(id));
    }

    @PutMapping("/job-applications/{id}")
    public ResponseEntity<String> update(@PathVariable long id,
                                         @RequestBody(required = false) String body) {

        if (!jobApplications.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job application not found");
        }

        jobApplications.put(id, body);

        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/job-applications/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (!jobApplications.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job application not found");
        }

        jobApplications.remove(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
