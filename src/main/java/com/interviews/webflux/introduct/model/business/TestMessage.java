package com.interviews.webflux.introduct.model.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessage {
    private Integer id;
    private String message;
    private LocalDateTime created;

}
