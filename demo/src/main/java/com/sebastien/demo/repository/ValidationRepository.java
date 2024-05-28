package com.sebastien.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sebastien.demo.entity.Validation;

@Repository
public interface ValidationRepository extends CrudRepository<Validation, Integer> {

}
