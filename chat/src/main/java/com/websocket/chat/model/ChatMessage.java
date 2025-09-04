package com.websocket.chat.model;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private TrayIcon.MessageType type;
    private String content;
    private String sender;
}
