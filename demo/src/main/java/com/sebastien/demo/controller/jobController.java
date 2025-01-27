package com.sebastien.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sebastien.demo.entity.job;
import com.sebastien.demo.service.jobService;

import ch.qos.logback.core.model.Model;

@RestController
public class jobController {
	@Autowired
	private jobService jobservice;
	
	
	// @CrossOrigin(origins = "*")
	@PostMapping("/jobs/new")
	public ResponseEntity<job> saveJob(@RequestBody job job) {
		System.out.println("Post request to /jobs/new");
		job savedjob = jobservice.saveJob(job);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedjob);
	}
	
	@GetMapping("/jobs/all")
	public Iterable<job> getJobs(){
		
		return jobservice.getJobs();
	}
	
	@GetMapping("/jobs/{id}")
	public job getJobById(@PathVariable("id") final Long id) {
		Optional<job> job = jobservice.getJob(id);
		if(job.isPresent()) {
			return job.get();
		} else {
			return null;
		}
	}
	
	
	@DeleteMapping("/jobs/{id}")
	public void deleteJob(@PathVariable("id") final Long id) {
		jobservice.deleteJob(id);
		
	}
	
	@PutMapping("/jobs/{id}")
	public job updateJob(@PathVariable("id") final Long id, @RequestBody job job) {
		Optional<job> e = jobservice.getJob(id);
		if(e.isPresent()) {
			job currentJob = e.get();
			
			String title = job.getTitle();
			if(title != null) {
				currentJob.setTitle(title);
			}
			
			String description = job.getDescription();
			if(description != null ) {
				currentJob.setDescription(description);
			}
			
			String contact = job.getContact();
			if(contact != null) {
				currentJob.setContact(contact);
			}
			
			Integer hot = job.getHot();
			if(hot != null) {
				currentJob.setHot(hot);
			}
			
			jobservice.saveJob(currentJob);
			return currentJob;
		}else {
			return null;
		}
	}
	
	
	
}
 