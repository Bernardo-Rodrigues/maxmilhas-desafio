package com.maxmilhas.desafio.api.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExistsCpfException extends RuntimeException {

    HttpStatus status = HttpStatus.CONFLICT;

    public ExistsCpfException() {
        super("CPF already exists.");
    }
}
