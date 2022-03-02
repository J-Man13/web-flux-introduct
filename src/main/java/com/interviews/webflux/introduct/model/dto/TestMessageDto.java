package com.interviews.webflux.introduct.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessageDto {
    private Integer id;
    private String message;
}
