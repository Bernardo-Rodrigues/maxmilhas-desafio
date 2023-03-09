package com.maxmilhas.desafio.api.domain.dto;

import lombok.*;

@Data
@Builder
public class CpfDto {
    private String id;
    private String cpf;
    private String createdAt;
}
