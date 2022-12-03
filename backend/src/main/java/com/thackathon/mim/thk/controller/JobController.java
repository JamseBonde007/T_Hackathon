package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Job;
import com.thackathon.mim.thk.service.JobService;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/job")
public class JobController {

    private final JobService jobService;

    public JobController(@NonNull final JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJob(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Job>> findJobs(Pageable page,
                                              @RequestParam Long person_id,
                                              @RequestParam(required = false)String jobType){
        return ResponseEntity.ok(jobService.findJobs(page, person_id, jobType));
    }
}
