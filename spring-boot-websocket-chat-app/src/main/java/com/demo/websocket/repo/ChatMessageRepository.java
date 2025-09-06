package com.demo.websocket.repo;

import com.demo.websocket.entity.ChatMessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    @Query("SELECT m FROM ChatMessage m ORDER BY m.timestamp DESC LIMIT ?1")
    List<ChatMessageEntity> findRecentMessages(int limit);

    Page<ChatMessageEntity> findAllByOrderByTimestampDesc(Pageable pageable);


}
