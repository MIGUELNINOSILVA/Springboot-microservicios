package com.miguel.jobsms.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobyid(Long id);
    boolean deleteJobById(Long id);
    boolean updateJob(long id, Job updatedJob);
}
