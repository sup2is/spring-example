package com.example.demo.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;	

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void test_유저를_db에_넣기() {
		User user = User.builder()
				.id("sup2is")
				.name("sup2")
				.password("qwer!23")
				.phone("010-0000-0000")
				.email("dev.sup2is@gmail.com")
				.build();
		
		//when
		userRepository.save(user);
	}
	
	@Test
	public void test_유저를_db에_저장후_name값으로_찾기() {
		
		//given
		
		//when
		User dbUser = userRepository.findByName("sup2");
		
		//then
		assertEquals("sup2is", dbUser.getId());
		System.out.println(dbUser.toString());
	}
	@Test
	public void test_유저를_db에_저장후_phone값으로_찾기() {
		
		//given
		
		//when
		User dbUser = userRepository.findByPhone("010-0000-0000");
		
		//then
		assertEquals("sup2is", dbUser.getId());
		System.out.println(dbUser.toString());
	}
	
	@Test
	public void test_유저를_db에_저장후_email값으로_찾기() {
		
		//given
		
		//when
		User dbUser = userRepository.findByEmail("dev.sup2is@gmail.com");
		
		//then
		assertEquals("sup2is", dbUser.getId());
		System.out.println(dbUser.toString());
	}
	
	@Test
	public void test_유저의_email을_site별로_검색하기() {
		
		//given
		User user = User.builder()
				.id("chlcc")
				.name("chlcc")
				.password("qwer!23")
				.phone("010-1111-1111")
				.email("dev.sup2is@naver.com")
				.build();
		
		userRepository.save(user);
		
		//when
		List<User> users = userRepository.findByEmailContaining("naver");
		
		//then
		assertEquals(1, users.size());
		System.out.println(users.toString());
		
		
	}

}
