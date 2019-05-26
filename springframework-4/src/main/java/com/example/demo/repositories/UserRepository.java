package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByName(String name);

	User findByPhone(String phone);
	
	User findByEmail(String email);
	
	@Query("select u from User u where u.email like %:site%")
	List<User> findByEmailContaining(@Param("site") String site);
	
//	List<User> findByEmailContaining(String site);
}



