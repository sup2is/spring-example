package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByName(String name);

	User findByPhone(String phone);
	
	User findByEmail(String email);
	
}
