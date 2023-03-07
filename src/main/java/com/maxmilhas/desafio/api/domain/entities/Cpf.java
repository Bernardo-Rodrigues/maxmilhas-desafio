package com.maxmilhas.desafio.api.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document
public class Cpf {
    @Id
    private String id;
    private String cpf;
    private LocalDateTime createdAt;
}
