package com.sup2is.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.sup2is.websocket.model.Chat;

@Controller
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
    @MessageMapping("/chat/{room}/{name}")
    public void chat(@DestinationVariable("room") String room,
    		@DestinationVariable("name") String name , String content) throws Exception {
    	simpMessagingTemplate.convertAndSend("/topic/" + room , new Chat(name, content));
    }

}