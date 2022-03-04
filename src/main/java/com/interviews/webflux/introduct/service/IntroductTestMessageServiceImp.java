package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.model.business.TestMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class IntroductTestMessageServiceImp implements IntroductTestMessageService {
    private final TestMessageService testMessageService;
    private final IntroductClient introductClient;

    public IntroductTestMessageServiceImp(TestMessageService testMessageService,
                                          IntroductClient introductClient) {
        this.testMessageService = testMessageService;
        this.introductClient = introductClient;
    }

    @Transactional
    @Override
    public Mono<Integer> callWebServiceSaveMessageAndReturnCode(String message) {
        return introductClient.callIntroductMessageAndReturnCode(message)
                .then(testMessageService.saveTestMessage(new TestMessage(message)))
                .map(TestMessage::getId);
    }
}
