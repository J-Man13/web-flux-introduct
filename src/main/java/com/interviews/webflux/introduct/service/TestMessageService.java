package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.model.business.TestMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestMessageService {
    Flux<TestMessage> findAllTestMessages();
    Mono<TestMessage> saveTestMessage(TestMessage testMessage);
}
