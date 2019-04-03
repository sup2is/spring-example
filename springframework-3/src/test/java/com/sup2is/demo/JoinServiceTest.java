package com.sup2is.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinServiceTest {
	
	@InjectMocks
	JoinServiceImpl joinService;
	
	@Mock
	CryptoService cryptoService;
	
	private User user;
	
	@Before
	public void setup() {
		user = new User("sup2is", "12345678");
	}
	
	@Test
	public void testVerify_provideUser_verifyIsTrue() {
		//given
		
		//when
		boolean isValid = joinService.verify(user);
			
		//then
		assertEquals(true, isValid);
	}
	
	@Test
	public void testJoin_provideUser_joinSuccess() {
		
		//given
		
		//when
		when(cryptoService.encrypt(user.getPw())).thenReturn("encrypted String");
		User encryptUser = joinService.join(user);
		
		//then
		assertEquals("encrypted String", encryptUser.getPw());
		
	}

}
