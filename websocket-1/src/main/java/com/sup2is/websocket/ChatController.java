package com.sup2is.websocket;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.sup2is.websocket.model.Greeting;
import com.sup2is.websocket.model.HelloMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat/")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, @Header("simpSessionId") String sessionId) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}