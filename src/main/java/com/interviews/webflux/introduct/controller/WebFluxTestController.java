package com.interviews.webflux.introduct.controller;

import com.interviews.webflux.introduct.mapstruct.TestMessageMapStruct;
import com.interviews.webflux.introduct.model.dto.TestMessageDto;
import com.interviews.webflux.introduct.service.TestMessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/test")
public class WebFluxTestController {

    private final TestMessageService testMessageService;
    private final TestMessageMapStruct testMessageMapStruct;

    public WebFluxTestController(TestMessageService testMessageService,
                                 TestMessageMapStruct testMessageMapStruct) {
        this.testMessageService = testMessageService;
        this.testMessageMapStruct = testMessageMapStruct;
    }

    @GetMapping
    public Flux<TestMessageDto> getAllMessages() {
        return testMessageService.findAllTestMessages().map(testMessageMapStruct::testMessageToTestMessageDto);
    }

    @PostMapping
    public Mono<TestMessageDto> savedRequestAndMakeExternalCall(@RequestBody TestMessageDto testMessageDto) {
        return null;
    }
}
