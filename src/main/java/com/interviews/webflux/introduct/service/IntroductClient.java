package com.interviews.webflux.introduct.service;

import reactor.core.publisher.Mono;
import wsdl.generated.client.GetMessageRequest;


public interface IntroductClient {
    Mono<Integer> callIntroductMessageAndReturnCode(String message);
}
