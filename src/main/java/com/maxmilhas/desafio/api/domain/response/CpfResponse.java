package com.maxmilhas.desafio.api.domain.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CpfResponse {
    private String cpf;
    private LocalDateTime createdAt;
}
