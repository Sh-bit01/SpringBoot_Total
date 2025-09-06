package com.demo.websocket.controller;

import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.entity.ChatMessageEntity;
import com.demo.websocket.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatHistoryController {

    private final ChatMessageService chatMessageService;

    @GetMapping("/history")
    public List<ChatMessageDTO> getHistory(@RequestParam(defaultValue = "20") int limit) {
        return chatMessageService.getRecentMessages(limit);
    }
}
