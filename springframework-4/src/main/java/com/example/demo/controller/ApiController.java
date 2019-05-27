package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public String save(@RequestBody User user) {
		try {
			userRepository.save(user);
			return "success";
		}catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	
	@GetMapping("/users")
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		try {
			Iterable<User> it = userRepository.findAll();
			for (User user : it) {
				users.add(user);
			}
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return users;
		}
	}
	
	
	@GetMapping("/user/containing/{site}")
	public List<User> findByEmailContaining(@PathVariable("site")String site) {
		List<User> users = new ArrayList<>();
		try {
			Iterable<User> it = userRepository.findByEmailContaining(site);
			for (User user : it) {
				users.add(user);
			}
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return users;
		}
	}
	
}
