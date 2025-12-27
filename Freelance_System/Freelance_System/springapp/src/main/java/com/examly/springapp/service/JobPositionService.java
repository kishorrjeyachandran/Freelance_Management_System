package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;

@Service
public class JobPositionService {
    private final JobPositionRepository repository;

    public JobPositionService(JobPositionRepository repository) {
        this.repository = repository;
    }

    public JobPosition addJobPosition(JobPosition job) {
        return repository.save(job);
    }

    public List<JobPosition> getAllJobPositions() {
        return repository.findAll();
    }

    public JobPosition getJobPositionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public JobPosition updateJobPosition(Long id, JobPosition updatedjob) {
    return repository.findById(id).map(existing -> {
        existing.setPositionTitle(updatedjob.getPositionTitle());
        existing.setDescription(updatedjob.getDescription());
        existing.setLocation(updatedjob.getLocation());
        existing.setExperienceRequired(updatedjob.getExperienceRequired());
        existing.setOpenings(updatedjob.getOpenings());
        return repository.save(existing);
        }).orElse(null);
    }

    public List<JobPosition> searchJobPositions(String keyword) {
        return repository.searchJobPositions(keyword);
    }

}
