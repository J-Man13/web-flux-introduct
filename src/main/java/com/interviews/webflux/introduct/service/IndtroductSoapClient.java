package com.interviews.webflux.introduct.service;

import com.interviews.webflux.introduct.mapstruct.TestMessageMapStruct;
import com.interviews.webflux.introduct.soap.utills.SoapEnvelopeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import wsdl.generated.client.GetMessageRequest;
import wsdl.generated.client.GetMessageResponse;

@Service
public class IndtroductSoapClient implements IntroductClient {

    private final WebClient webClient;
    private final String soapServiceUrl;
    private final TestMessageMapStruct testMessageMapStruct;

    public IndtroductSoapClient(WebClient webClient,
                                @Value("${soap.service.url}") String soapServiceUrl,
                                TestMessageMapStruct testMessageMapStruct) {
        this.webClient = webClient;
        this.soapServiceUrl = soapServiceUrl;
        this.testMessageMapStruct = testMessageMapStruct;
    }

    public Mono<Integer> callIntroductMessageAndReturnCode(String message){
        GetMessageRequest getMessageRequest = new GetMessageRequest();
        getMessageRequest.setMessage(message);
        SoapEnvelopeRequest soapEnvelopeRequest = new SoapEnvelopeRequest(null, getMessageRequest);

        return webClient.post()
                .uri(soapServiceUrl)
                .contentType(MediaType.TEXT_XML)
                .body(Mono.just(soapEnvelopeRequest), SoapEnvelopeRequest.class)
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        clientResponse ->
                                clientResponse
                                        .bodyToMono(String.class)
                                        .flatMap(
                                                errorResponseBody ->
                                                        Mono.error(
                                                                new ResponseStatusException(
                                                                        clientResponse.statusCode(),
                                                                        errorResponseBody))))

                .bodyToMono(GetMessageResponse.class)
                .map(GetMessageResponse::getResultCode);
    }
}
