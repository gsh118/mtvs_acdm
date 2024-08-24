package com.a2.midnightbe.aireqeust.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class AiChatInput {

    @Schema(description = "소개 대상", example = "암행어사 마패")
    private String talk;

    public AiChatInput() {}

    public AiChatInput(String talk) {
        this.talk = talk;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "AiChatInput{" +
                "talk='" + talk + '\'' +
                '}';
    }
}
