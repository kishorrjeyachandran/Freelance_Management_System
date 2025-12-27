package com.examly.springapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;

@RestController
@RequestMapping("/api/interview-feedbacks")

public class InterviewFeedbackController {
    @Autowired
    private final InterviewFeedbackService service;

    public InterviewFeedbackController(InterviewFeedbackService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<InterviewFeedback> addInterviewFeedback(@RequestBody InterviewFeedback interview) {
        InterviewFeedback saved = service.addInterviewFeedback(interview);
        return ResponseEntity.created(URI.create("/api/interview-feedbacks/" + saved.getInterviewFeedbackId())).body(saved);
    }
    @GetMapping
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return service.getAllInterviewFeedbacks();
    }

    @PutMapping("/{interviewFeedbackId}")
    public ResponseEntity<InterviewFeedback> updateInterviewFeedback(@PathVariable Long interviewFeedbackId, @RequestBody InterviewFeedback interviewFeedback) {
        InterviewFeedback updated = service.updateInterviewFeedback(interviewFeedbackId, interviewFeedback);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(@PathVariable Long id) {
        InterviewFeedback interview = service.getInterviewFeedbackById(id);
        if(interview == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(interview);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<List<InterviewFeedback>> getGetFeedbacksByJobApplication(@PathVariable Long id) {
        List<InterviewFeedback> interview = service.getGetFeedbacksByJobApplication(id);
        if(interview == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(interview);
    }
}
