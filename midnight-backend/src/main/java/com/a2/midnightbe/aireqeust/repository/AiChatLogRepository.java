package com.a2.midnightbe.aireqeust.repository;

import com.a2.midnightbe.aireqeust.entity.AiChatLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AiChatLogRepository extends JpaRepository<AiChatLog, Long> {

    public List<AiChatLog> findAiChatLogByChatQuestion(String chatQuestion);
}
