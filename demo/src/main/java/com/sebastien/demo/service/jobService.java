package com.sebastien.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastien.demo.entity.job;
import com.sebastien.demo.repository.jobRepository;

import lombok.Data;

@Data
@Service	
public class jobService {
	
	@Autowired
	private jobRepository jobRepository;
	
	public Optional<job> getJob(final Long id){
		return jobRepository.findById(id);
	}
	
	public Iterable<job> getJobs(){
		System.out.println("Retrieving all services ");
		System.out.println(jobRepository.findAll());
		return jobRepository.findAll();
		
	}
	
	public void deleteJob(final Long id) {
		jobRepository.deleteById(id);
	}
	
	public job saveJob(job job) {
		System.out.println("Saving job "+ job);
		job savedJob = jobRepository.save(job);
		System.out.println("Saving the Job: "+ savedJob);
		return savedJob;
	}
	
	
}