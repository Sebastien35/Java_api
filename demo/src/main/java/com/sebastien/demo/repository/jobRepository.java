package com.sebastien.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sebastien.demo.entity.job;
@Repository
public interface jobRepository extends CrudRepository<job, Long>{
}