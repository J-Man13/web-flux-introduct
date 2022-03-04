package com.interviews.webflux.introduct.mapstruct;

import com.interviews.webflux.introduct.model.business.TestMessage;
import com.interviews.webflux.introduct.model.dto.TestMessageDto;
import com.interviews.webflux.introduct.model.entity.TestMessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMessageMapStruct {
    TestMessage testMessageDtoToTestMessage(TestMessageDto testMessageDto);
    TestMessageDto testMessageToTestMessageDto(TestMessage testMessage);
    TestMessageEntity testMessageToTestMessageEntity(TestMessage testMessage);
    TestMessage testMessageEntityToTestMessage(TestMessageEntity testMessageEntity);
}
