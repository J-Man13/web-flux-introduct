package com.interviews.webflux.introduct.controller;

import com.interviews.webflux.introduct.mapstruct.TestMessageMapStruct;
import com.interviews.webflux.introduct.model.dto.TestMessageDto;
import com.interviews.webflux.introduct.service.TestMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


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
    private Flux<TestMessageDto> getAllMessages() {
        return testMessageService.findAllTestMessages().map(testMessageMapStruct::testMessageToTestMessageDto);
    }
}
