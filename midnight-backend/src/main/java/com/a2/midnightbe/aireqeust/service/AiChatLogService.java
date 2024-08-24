package com.a2.midnightbe.aireqeust.service;

import com.a2.midnightbe.aireqeust.DTO.AiChatLogDTO;
import com.a2.midnightbe.aireqeust.entity.AiChatLog;
import com.a2.midnightbe.aireqeust.repository.AiChatLogRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AiChatLogService {

    private AiChatLogRepository aiChatLogRepository;

    public AiChatLogService(AiChatLogRepository aiChatLogRepository) {
        this.aiChatLogRepository = aiChatLogRepository;
    }

    public List<AiChatLogDTO> findAllLog() {

        return aiChatLogRepository.findAll()
                .stream()
                .map(AiChatLogDTO::new)
                .collect(Collectors.toList());

    }

    @Transactional
    public void addChatLog(AiChatLogDTO aiChatLogInfo) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("채팅 로그 업로드");
        aiChatLogRepository.save(AiChatLogDTO.aiChatLogEntityFromDTO(aiChatLogInfo));
        logger.trace("채팅 로그 업로드 완료");

    }

    @Transactional
    public void updateLogFeedBack(long chatLogId, String feedBack){
        System.out.println("좋아요 여부: "+feedBack);
        AiChatLog aiChatLog = aiChatLogRepository.findById(chatLogId).orElseThrow(
                ()->new IllegalArgumentException("존재하지 않는 아이디"));

        aiChatLog.setIsGood(feedBack);
    }

    public List<AiChatLogDTO> findLogBySubject(String subject) {

        return aiChatLogRepository.findAiChatLogByChatQuestion(subject)
                .stream()
                .map(AiChatLogDTO::new)
                .collect(Collectors.toList());
    }
}
