package com.maxmilhas.desafio.api.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Cpf {
    @Id
    private String id;
    @Indexed(unique = true)
    private String cpf;
    private String createdAt;
}
