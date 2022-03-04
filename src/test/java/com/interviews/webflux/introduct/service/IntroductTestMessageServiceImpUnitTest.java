package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.model.business.TestMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {IntroductTestMessageServiceImp.class})
@ExtendWith(SpringExtension.class)
public class IntroductTestMessageServiceImpUnitTest {
    @Autowired
    private IntroductTestMessageServiceImp introductTestMessageServiceImp;

    @MockBean
    private TestMessageService testMessageService;
    @MockBean
    private IntroductClient introductClient;

    @Test
    public void callWebServiceSaveMessageAndReturnCodeTest(){
        //arrange
        String testMessage = "test";
        Mockito.doReturn(Mono.just(1)).when(introductClient).callIntroductMessageAndReturnCode(testMessage);
        Mockito.doReturn(Mono.just(new TestMessage(testMessage))).when(testMessageService).saveTestMessage(new TestMessage(testMessage));

        //act
        introductTestMessageServiceImp.callWebServiceSaveMessageAndReturnCode(testMessage);

        //assert
        Mockito.verify(introductClient, Mockito.times(1)).callIntroductMessageAndReturnCode(Mockito.anyString());
        Mockito.verify(testMessageService, Mockito.times(1)).saveTestMessage(Mockito.any(TestMessage.class));
    }

}
