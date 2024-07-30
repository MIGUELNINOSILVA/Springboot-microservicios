package com.miguel.jobsms.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController{
    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(this.jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getOne(@PathVariable(name = "id") Long id) {

        Job job = this.jobService.getJobyid(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public String create(@RequestBody Job job){
        this.jobService.createJob(job);
        return "Job created successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Job> delete(@PathVariable(name = "id") Long id){
        boolean jobDeleted = this.jobService.deleteJobById(id);
        if (jobDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> update(@PathVariable(name = "id") Long id, @RequestBody Job job) {
        boolean jobUpdated = this.jobService.updateJob(id, job);
        if (jobUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
