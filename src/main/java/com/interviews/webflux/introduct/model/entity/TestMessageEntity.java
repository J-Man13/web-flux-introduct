package com.interviews.webflux.introduct.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "testMessage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMessageEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;
}
