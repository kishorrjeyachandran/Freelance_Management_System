package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.JobPosition;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition,Long>{
    @Query(
        "SELECT j FROM JobPosition j " +
        "WHERE LOWER(j.positionTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "OR LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%'))"
    )
    List<JobPosition> searchJobPositions(@Param("keyword") String keyword);

}