package com.a2.midnightbe.aireqeust.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_chat_log")
@Getter
public class AiChatLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ChatId;

    //private String chatSubject;
    private String chatQuestion;
    private String chatAnswer;
    private String isGood;
    private LocalDateTime dateTime;
    //@Embedded
    private String prompt;
    //private CurationType curationType;

    protected AiChatLog() {}

    public AiChatLog(String chatQuestion, String chatAnswer, String isGood, LocalDateTime dateTime, String prompt) {
        this.chatQuestion = chatQuestion;
        this.chatAnswer = chatAnswer;
        this.isGood = isGood;
        this.dateTime = dateTime;
        this.prompt = prompt;
    }

    public void setIsGood(String isGood) {
        this.isGood = isGood;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

}
