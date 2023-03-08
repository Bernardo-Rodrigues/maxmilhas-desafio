package com.maxmilhas.desafio.api.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidCpfException extends RuntimeException {

    HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidCpfException() {
        super("CPF is not valid.");
    }
}
