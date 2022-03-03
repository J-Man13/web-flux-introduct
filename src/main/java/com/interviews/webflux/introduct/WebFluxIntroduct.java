package com.interviews.webflux.introduct;


import com.interviews.webflux.introduct.model.entity.TestMessageEntity;
import com.interviews.webflux.introduct.repository.TestMessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.stream.Stream;


@SpringBootApplication
public class WebFluxIntroduct {
    private final TestMessageRepository testMessageRepository;

    public WebFluxIntroduct(TestMessageRepository testMessageRepository) {
        this.testMessageRepository = testMessageRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebFluxIntroduct.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartUp() {
        System.out.println("Inserting some test values in repository");
        Stream<TestMessageEntity> stream = Stream.of(
                new TestMessageEntity(null, "test1", LocalDateTime.now()),
                new TestMessageEntity(null, "test2", LocalDateTime.now()),
                new TestMessageEntity(null, "test3", LocalDateTime.now())
        );
        testMessageRepository.saveAll(Flux.fromStream(stream)).subscribe();
        System.out.println("Completed inserting!!!");
    }
}
