package com.rustdetector.jobdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobDataRepository extends JpaRepository<JobData, Long> {
    @Query("SELECT j FROM JobData j WHERE j.month = ?1 AND j.year = ?2")
    Optional<JobData> findJobDataByMonthYear(Integer month, Integer year);
}

