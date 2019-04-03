package com.sup2is.demo;

import org.springframework.stereotype.Service;

@Service
public interface JoinService {
	
	public User join(User user);
	
	public boolean verify(User user);

}
