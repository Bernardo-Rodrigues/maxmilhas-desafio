package com.maxmilhas.desafio.api.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundCpfException extends RuntimeException {

    HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundCpfException() {
        super("CPF was not found");
    }
}
