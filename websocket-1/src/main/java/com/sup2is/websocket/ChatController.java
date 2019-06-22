package com.sup2is.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
    @MessageMapping("/chat/{room}")
    public void chat(@DestinationVariable("room") String room, 
    		@DestinationVariable("user") String user, 
    		@DestinationVariable("content") String content) throws Exception {
    	
    	simpMessagingTemplate.convertAndSend("/topic/" + room , content);
    }

}