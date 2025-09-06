package com.demo.websocket.mapper;

import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.entity.ChatMessageEntity;

import java.time.Instant;
import java.time.ZoneId;

public class ChatMessageMapper {
    public static ChatMessageEntity toEntity(ChatMessageDTO dto) {
        return ChatMessageEntity.builder()
                .type(dto.getType())
                .content(dto.getContent())
                .sender(dto.getSender())
                .build();
    }

    public static ChatMessageDTO toDTO(ChatMessageEntity entity) {
        return ChatMessageDTO.builder()
                .type(entity.getType())
                .content(entity.getContent())
                .sender(entity.getSender())
                .timestamp(entity.getTimestamp())
                .build();
    }

}
