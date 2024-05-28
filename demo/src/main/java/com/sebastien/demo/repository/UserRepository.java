package com.sebastien.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sebastien.demo.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
