package com.demo.websocket.dto;

import com.demo.websocket.chat.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageDTO {

    private MessageType type;
    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
