package com.a2.midnightbe.aireqeust.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AiChatResult {
    @Schema(description = "채팅 답변", example="숭례문이 대표적인 문화재입니다.")
    private String result;
    @Schema(description = "오디오 파일")
    private String audio_file;
}
