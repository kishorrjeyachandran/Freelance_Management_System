package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;

@Service
public class InterviewFeedbackService {
    private final InterviewFeedbackRepository repository;

    public InterviewFeedbackService(InterviewFeedbackRepository repository) {
        this.repository = repository;
    }
    public InterviewFeedback addInterviewFeedback(InterviewFeedback interview) {
        return repository.save(interview);
    }
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return repository.findAll();
    }
    public InterviewFeedback getInterviewFeedbackById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public InterviewFeedback updateInterviewFeedback(Long interviewFeedbackId, InterviewFeedback updatedInterviewFeedback) {
        return repository.findById(interviewFeedbackId).map(existing -> {
            
            existing.setContent(updatedInterviewFeedback.getContent());
            existing.setIsInternal(updatedInterviewFeedback.getIsInternal());
            existing.setInterviewRound(updatedInterviewFeedback.getInterviewRound());
            
            return repository.save(existing);
        }).orElse(null);
    }

    public List<InterviewFeedback> getGetFeedbacksByJobApplication(Long id) {
        return repository.findById(id).map(List::of).orElse(List.of());
    }

}
