package com.sup2is.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired(required=false)
	private CryptoService cryptoService;
	
	@Override
	public User join(User user) {
		//user pw 암호화
		user.setPw(cryptoService.encrypt(user.getPw()));
		
		//join ... db에 넣는 로직 .. 
		return user;
	}

	@Override
	public boolean verify(User user) {
		
		// id는 5자 이상 pw는 8자 이상
		if(user.getId().length() >= 5 && user.getPw().length() >= 8) {
			return true;
		}
		
		return false;
	}

}
