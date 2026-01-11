package com.demo.websocket.controller;

import com.demo.websocket.dto.TypingStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TypingController {

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public TypingStatus typing(TypingStatus status) {
        System.out.println("Typing event: " + status.getSender());
        return status;
    }
}
