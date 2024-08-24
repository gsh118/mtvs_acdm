package com.a2.midnightbe.aireqeust.DTO;

import com.a2.midnightbe.aireqeust.entity.AiChatLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AiChatLogDTO {
    private long chatId;
    //private String chatSubject;
    private String chatQuestion;
    private String chatAnswer;
    private String isGood;
    private LocalDateTime chatDateTime;
    private String prompt;
    //private CurationType curationType;

    public AiChatLogDTO(AiChatLog aiChatLog) {
        this(aiChatLog.getChatId(),
                aiChatLog.getChatQuestion(),
                aiChatLog.getChatAnswer(),
                aiChatLog.getIsGood(),
                aiChatLog.getDateTime(),
                aiChatLog.getPrompt());
                //aiChatLog.getCurationType());
    }

    public static AiChatLog aiChatLogEntityFromDTO(AiChatLogDTO aiChatDTO){
        return new AiChatLog(
                aiChatDTO.getChatQuestion(),
                aiChatDTO.getChatAnswer(),
                aiChatDTO.getIsGood(),
                aiChatDTO.getChatDateTime(),
                aiChatDTO.getPrompt()
                //aiChatDTO.getCurationType()
        );
    }
}
