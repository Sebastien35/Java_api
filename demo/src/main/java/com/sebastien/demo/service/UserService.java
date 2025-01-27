package com.sebastien.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sebastien.demo.roleName;
import com.sebastien.demo.entity.Role;
import com.sebastien.demo.entity.User;
import com.sebastien.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void register(User user) {
		if(user.getEmail().indexOf("@") == -1) {
			throw new RuntimeException("Email invalide");
		}
		if(!user.getEmail().contains(".")) {
			throw new RuntimeException("Email invalide");
		}
		String CryptedPwd = this.passwordEncoder.encode(user.getPassword());
		
		user.setPassword(CryptedPwd);
		
		Role  roleUser = new Role();
		roleUser.setNom_du_role(roleName.USER);
		user.setRole(roleUser);
		
		
		this.userRepo.save(user);
	}

}
