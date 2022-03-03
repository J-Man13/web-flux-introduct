package com.interviews.webflux.introduct.repository;


import com.interviews.webflux.introduct.model.entity.TestMessageEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMessageRepository extends ReactiveCrudRepository<TestMessageEntity, Integer> {

}
