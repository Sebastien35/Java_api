package com.sebastien.demo.service;

import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastien.demo.entity.User;
import com.sebastien.demo.entity.Validation;
import com.sebastien.demo.repository.ValidationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ValidationService {

	@Autowired
	private ValidationRepository validationRepo;
	
	public void save(User user) {
		Validation validation = new Validation();
		validation.setUser(user);
		Instant creation = Instant.now();
		Instant expiration = creation.plusSeconds(600);
		
		Random random = new Random();
		int randomInteger = random.nextInt(999999);
		String code = String.format("%06d", randomInteger);
		validation.setExpire(expiration);
		validation.setCode(code);
		
		this.validationRepo.save(validation);
		
		
		
		
		
	}
}
