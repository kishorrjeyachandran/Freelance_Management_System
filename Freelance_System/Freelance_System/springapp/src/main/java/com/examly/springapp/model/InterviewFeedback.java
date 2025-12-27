package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InterviewFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviewFeedbackId;

    private String content;

    private Boolean isInternal;

    private String interviewRound;


    public Boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }
    public InterviewFeedback(){}
    public InterviewFeedback(String content, Boolean isInternal, String interviewRound) {
        this.content = content;
        this.isInternal = isInternal;
        this.interviewRound = interviewRound;
    }
    public Long getInterviewFeedbackId() {
        return interviewFeedbackId;
    }
    public void setInterviewFeedbackId(Long interviewFeedbackId) {
        this.interviewFeedbackId = interviewFeedbackId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getInterviewRound() {
        return interviewRound;
    }
    public void setInterviewRound(String interviewRound) {
        this.interviewRound = interviewRound;
    }    

    
}

