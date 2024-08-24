package com.a2.midnightbe.aireqeust.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AiChatDTO {
    private String chatQuestion;
    private String chatAnswer;
    private LocalDateTime questionDateTime;
}
