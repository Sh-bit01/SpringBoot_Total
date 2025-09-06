package com.demo.websocket.chat;

import com.demo.websocket.config.WebSocketEventListener;
import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final WebSocketEventListener webSocketEventListener;
    private final ChatMessageService chatMessageService;

    public ChatController(WebSocketEventListener webSocketEventListener,
                          ChatMessageService chatMessageService) {
        this.webSocketEventListener = webSocketEventListener;
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDTO sendMessage(
            @Payload ChatMessageDTO chatMessageDTO
    ) {
        // Store message in DB
        chatMessageService.saveMessage(chatMessageDTO);

        return chatMessageDTO;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDTO addUser(
            @Payload ChatMessageDTO chatMessageDTO,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessageDTO.getSender());

        // Register user as online
        webSocketEventListener.addOnlineUser(chatMessageDTO.getSender());
        // Store message in DB
        chatMessageService.saveMessage(chatMessageDTO);
        return chatMessageDTO;
    }
}
