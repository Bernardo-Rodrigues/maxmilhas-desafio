package com.maxmilhas.desafio.api.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class CpfDto {
    private String id;
    private String cpf;
    private LocalDateTime createdAt;
}
