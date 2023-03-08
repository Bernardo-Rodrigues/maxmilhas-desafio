package com.maxmilhas.desafio.api.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StandardError {

    private String type;
    private String message;

}
