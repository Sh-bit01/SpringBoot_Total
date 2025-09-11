package com.demo.websocket.controller;


import com.demo.websocket.chat.MessageType;
import com.demo.websocket.dto.ChatMessageDTO;
import com.demo.websocket.service.ChatMessageService;
import com.demo.websocket.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final SimpMessagingTemplate messagingTemplate;
    private final FileStorageService fileStorageService;
    private final ChatMessageService chatMessageService;

    public FileUploadController(SimpMessagingTemplate messagingTemplate, FileStorageService fileStorageService,
                                ChatMessageService chatMessageService) {
        this.messagingTemplate = messagingTemplate;
        this.fileStorageService = fileStorageService;
        this.chatMessageService = chatMessageService;
    }

    String fileUrl = null;


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam("sender") String sender) {
        try {
            fileUrl = fileStorageService.storeFile(file);
            ChatMessageDTO chatMessageDTO = new ChatMessageDTO();
            chatMessageDTO.setSender(sender);
            chatMessageDTO.setContent(fileUrl);
            chatMessageDTO.setType(MessageType.IMAGE);

            chatMessageService.saveMessage(chatMessageDTO);
            messagingTemplate.convertAndSend("/topic/public", chatMessageDTO);
            return ResponseEntity.ok().body(fileUrl);
        } catch (Exception e) {
            if (fileUrl != null) {
                fileStorageService.deleteFile(fileUrl);
            }
            return ResponseEntity.badRequest().body("Could not upload file: " + e.getMessage());
        }
    }
}