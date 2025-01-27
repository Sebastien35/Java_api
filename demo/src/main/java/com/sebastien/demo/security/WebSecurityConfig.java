package com.sebastien.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	           .csrf(AbstractHttpConfigurer::disable)
	           .authorizeHttpRequests(authorize -> authorize
	                   .requestMatchers(HttpMethod.GET, "/").permitAll()
	                   .requestMatchers(HttpMethod.POST, "/register").permitAll()
	                   .requestMatchers(HttpMethod.GET, "/login").permitAll()
	                   .requestMatchers(HttpMethod.GET, "/jobs/all").permitAll()
	                   .anyRequest().authenticated())
	           .build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}