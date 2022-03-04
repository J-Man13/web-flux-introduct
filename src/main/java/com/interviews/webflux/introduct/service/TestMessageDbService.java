package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.mapstruct.TestMessageMapStruct;
import com.interviews.webflux.introduct.model.business.TestMessage;
import com.interviews.webflux.introduct.repository.TestMessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TestMessageDbService implements TestMessageService{
    private final TestMessageRepository testMessageRepository;
    private final TestMessageMapStruct testMessageMapStruct;

    public TestMessageDbService(TestMessageRepository testMessageRepository,
                                TestMessageMapStruct testMessageMapStruct) {
        this.testMessageRepository = testMessageRepository;
        this.testMessageMapStruct = testMessageMapStruct;
    }


    @Override
    public Flux<TestMessage> findAllTestMessages() {
        return testMessageRepository.findAll()
                .doOnNext(System.out::println)
                .map(testMessageMapStruct::testMessageEntityToTestMessage);
    }

    @Override
    public Mono<TestMessage> saveTestMessage(TestMessage testMessage) {
        testMessage.setCreated(LocalDateTime.now());
        return testMessageRepository.save(testMessageMapStruct.testMessageToTestMessageEntity(testMessage))
                .map(testMessageMapStruct::testMessageEntityToTestMessage);
    }
}
