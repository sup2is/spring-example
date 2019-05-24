package com.example.demo.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;	

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	
	@Test
	public void testSave_user_insert하기() {
		//given
		User user = User.builder()
				.id("sup2is")
				.name("sup2")
				.password("qwer!23")
				.phone("010-0000-0000")
				.email("dev.sup2is@gmail.com")
				.build();
		
		//when
		userRepository.save(user);
		
		System.out.println();
	}
	
	
	@Test
	public void testFindByName_name값으로_찾기() {
		
		//given
//		User user = User.builder()
//				.id("sup2is")
//				.name("sup2")
//				.password("qwer!23")
//				.phone("010-0000-0000")
//				.email("dev.sup2is@gmail.com")
//				.build();
		
		//when
//		userRepository.save(user);
		
		//then
		User dbUser = userRepository.findByName("sup2");
		
		assertEquals("sup2", dbUser.getName());
		System.out.println(dbUser.toString());
	}

}
