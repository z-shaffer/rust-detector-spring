package com.rustdetector.jobdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/jobdata")
public class JobDataController {
    private final JobDataService jobDataService;

    @Autowired
    public JobDataController(JobDataService jobDataService) {
        this.jobDataService = jobDataService;
    }

    @GetMapping
    public List<JobData> getAllJobData()
    {
        return jobDataService.getAllJobData();
    }

    @PostMapping
    public void fetchJobData(@RequestBody JobData jobData)
    {
        jobDataService.recordJobData(jobData);
    }

    @DeleteMapping(path = "{jobDataId}")
    public void deleteJobData(@PathVariable("jobDataId") Long jobDataId) {
        jobDataService.deleteJobData(jobDataId);
    }

    @PutMapping(path = "{jobDataId}")
    public void updateStudent(
            @PathVariable("jobDataId") Long jobDataId,
            @RequestParam(required = false) Integer rustCount,
            @RequestParam(required = false) Integer goCount,
            @RequestParam(required = false) Integer pythonCount)
    {
        jobDataService.updateJobData(jobDataId, rustCount, goCount, pythonCount);
    }
}
