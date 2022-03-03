package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.model.business.TestMessage;
import reactor.core.publisher.Flux;

public interface TestMessageService {
    Flux<TestMessage> findAllTestMessages();
}
