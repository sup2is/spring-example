package com.sup2is.websocket;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	@MessageMapping("/greeting") 
    public String handle(String greeting) {
        return "[" + new Date(System.currentTimeMillis()) + ": " + greeting;
    }
	
}
