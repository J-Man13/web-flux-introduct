package com.interviews.webflux.introduct.controller;

import com.interviews.webflux.introduct.model.dto.TestMessageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class WebFluxTestController {

    @GetMapping("/{id}")
    private Mono<TestMessageDto> getEmployeeById(@PathVariable Integer id) {
        return Mono.justOrEmpty(new TestMessageDto(1,"test"));
    }
}
