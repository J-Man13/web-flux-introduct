package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.model.business.TestMessage;
import reactor.core.publisher.Mono;

public interface IntroductTestMessageService {
    Mono<Integer> callWebServiceSaveMessageAndReturnCode(String message);
}
