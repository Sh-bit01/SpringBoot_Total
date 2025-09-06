package com.demo.websocket.config;

import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    // Store online users (thread-safe)
    private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    private final SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        log.info("Received a new web socket connection");
    }
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            // remove user when disconnected
            onlineUsers.remove(username);

            log.info("User disconnected: {}, online users: {}", username, onlineUsers.size());
            var chatMessage = ChatMessageDTO.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
            messagingTemplate.convertAndSend("/topic/onlineCount", onlineUsers.size());
            messagingTemplate.convertAndSend("/topic/onlineUsers", onlineUsers);

        }
    }

    // Call this when user joins (e.g. after login or SUBSCRIBE event)
    public void addOnlineUser(String username) {
        onlineUsers.add(username);
        log.info("User connected: {}, online users: {}", username, onlineUsers.size());
        messagingTemplate.convertAndSend("/topic/onlineCount", onlineUsers.size());
        messagingTemplate.convertAndSend("/topic/onlineUsers", onlineUsers);
    }

    public int getOnlineUserCount() {
        return onlineUsers.size();
    }

    public Set<String> getOnlineUsersName(){
        return onlineUsers;
    }
}
