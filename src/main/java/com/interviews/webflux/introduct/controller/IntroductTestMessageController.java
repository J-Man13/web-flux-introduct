package com.interviews.webflux.introduct.controller;

import com.interviews.webflux.introduct.service.IntroductTestMessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/introduct-test-message")
public class IntroductTestMessageController {
    private final IntroductTestMessageService introductTestMessageService;

    public IntroductTestMessageController(IntroductTestMessageService introductTestMessageService) {
        this.introductTestMessageService = introductTestMessageService;
    }

    //Instead of request body map it is better to use dto, but it is not going on prod, so whatever
    @PostMapping
    public Mono<Integer> callWebServiceSaveMessageAndReturnCode(@RequestBody Map<String, String> request) {
        return introductTestMessageService.callWebServiceSaveMessageAndReturnCode(request.get("message"));
    }
}
