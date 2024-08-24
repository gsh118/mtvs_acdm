package com.a2.midnightbe.aireqeust;

import com.a2.midnightbe.aireqeust.DTO.AiChatInput;
import com.a2.midnightbe.aireqeust.DTO.AiChatLogDTO;
import com.a2.midnightbe.aireqeust.DTO.AiChatResult;
import com.a2.midnightbe.aireqeust.service.AiChatLogService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class AiRequestController {

    private AiChatLogService aiChatLogService;
    private Logger logger;

    public AiRequestController(AiChatLogService aiChatLogService) {
        this.aiChatLogService = aiChatLogService;
        logger= LoggerFactory.getLogger(getClass());
    }

    public static String IP = "192.168.1.59";
    public static String PORT = "7880";


    @Operation(summary = "인공지능 모델 호출", description = "문화재에 대한 설명을 텍스트와 음성 파일로 제공")
    @PostMapping("chatbot")
    public AiChatResult getAiChat(@RequestBody AiChatInput aiChatInput){

        System.out.println(aiChatInput);

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
                .build();

        WebClient webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .baseUrl("http://"+IP+":"+PORT)
                .build();

        AiChatResult aiChatResult = webClient.post()
                .uri("/chatbot")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(aiChatInput)
                .retrieve()
                .bodyToMono(AiChatResult.class)
                .block();

        AiChatLogDTO aiChatInfo = new AiChatLogDTO(0, aiChatInput.getTalk(),
                aiChatResult.getResult(), null, LocalDateTime.now(), null);

        String defaultPrompt = "당신은 한국 문화재 큐레이터입니다." +
                " 방문객의 답변에 성실하게 답변해 주시면 됩니다. 답변중에 **은 빼주세요." +
                " 말투는 옛날 궁궐에서 사용하던 말투로 하면 됩니다. 답변시에는 존댓말을 사용해야 합니다." +
                " 일상적인 대화에서도 궁궐에서 사용하던 말투로 답변해야 합니다." +
                " 공백을 포함하여 250자 이내로 답변해주세요.";

        if (aiChatInfo.getPrompt()==null){
            aiChatInfo.setPrompt(defaultPrompt);
        }

        logger.info("모델에서 받은 답변: " + aiChatResult.getResult());
        //System.out.println();

        aiChatLogService.addChatLog(aiChatInfo);
        return aiChatResult;
    }

    @Operation(summary = "챗봇 대화 내역 조회", description = "챗봇과 대화한 전체 목록을 조회")
    @GetMapping("chatLog")
    public List<AiChatLogDTO> getAiChatLogList(@RequestParam(name="subject") @Nullable  String subject){
        if(subject==null) {
            return aiChatLogService.findAllLog();
        } else{
            return aiChatLogService.findLogBySubject(subject);
        }

    }

    @Operation(summary = "챗봇 답변 만족도 체크", description = "챗봇의 답변이 만족스러웠는지 체크")
    @PutMapping("chatLogFeedback/{id}")
    public void getChatLogFeedBack(@RequestParam long id, @RequestBody String feedBackType){
        aiChatLogService.updateLogFeedBack(id, feedBackType);
    }

}
