package com.rustdetector.jobdata;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobDataService {
    private final JobDataRepository jobDataRepository;

    @Autowired
    public JobDataService(JobDataRepository jobDataRepository) {
        this.jobDataRepository = jobDataRepository;
    }

    public List<JobData> getAllJobData()
    {
        return jobDataRepository.findAll();
    }

    public void recordJobData(JobData jobData) {
        Optional<JobData> jobDataOptional = jobDataRepository.findJobDataByMonthYear(jobData.getMonth(), jobData.getYear());
        if(jobDataOptional.isPresent())
        {
            throw new IllegalStateException("Month already recorded");
        }
        jobDataRepository.save(jobData);
    }

    public void deleteJobData(Long jobdataId) {
        boolean exists = jobDataRepository.existsById(jobdataId);
        if (!exists)
        {
            throw new IllegalStateException("job data ID " + jobdataId + " not found.");
        }
        jobDataRepository.deleteById(jobdataId);
    }

    @Transactional
    public void updateJobData(Long jobDataId,
                              Integer rustCount,
                              Integer goCount,
                              Integer pythonCount)
    {
        JobData jobData = jobDataRepository.findById(jobDataId)
                .orElseThrow(() -> new IllegalStateException("Job Data ID " + jobDataId + " does not exist"));
        if (rustCount != null && rustCount >= 0 && !Objects.equals(jobData.getRustCount(), rustCount))
        {
            jobData.setRustCount(rustCount);
        }
        if (goCount != null && goCount >= 0 && !Objects.equals(jobData.getGoCount(), goCount))
        {
            jobData.setGoCount(goCount);
        }
        if (pythonCount != null && pythonCount >= 0 && !Objects.equals(jobData.getPythonCount(), pythonCount))
        {
            jobData.setPythonCount(pythonCount);
        }
    }
}
