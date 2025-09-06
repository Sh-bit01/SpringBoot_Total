package com.demo.websocket.service;

import com.demo.websocket.mapper.ChatMessageMapper;
import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.repo.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository repository;

    public void saveMessage(ChatMessageDTO dto) {
        repository.save(ChatMessageMapper.toEntity(dto));
    }

    public List<ChatMessageDTO> getRecentMessages(int limit) {
        return repository.findAllByOrderByTimestampDesc(PageRequest.of(0, limit))
                .getContent()
                .stream()
                .map(ChatMessageMapper::toDTO)
                .toList();// oldest first
    }
}

