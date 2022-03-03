package com.interviews.webflux.introduct.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("TEST_MESSAGE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessageEntity {
    @Id
    private Integer id;
    @Column
    private String message;
    @Column
    private LocalDateTime created;
}
