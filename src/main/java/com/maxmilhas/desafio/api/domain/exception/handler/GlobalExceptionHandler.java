package com.maxmilhas.desafio.api.domain.exception.handler;

import com.maxmilhas.desafio.api.domain.exception.InvalidCpfException;
import com.maxmilhas.desafio.api.domain.exception.NotFoundCpfException;
import com.maxmilhas.desafio.api.domain.exception.StandardError;
import com.maxmilhas.desafio.api.services.impl.CpfValidatorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpfValidatorServiceImpl.class);

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<StandardError> invalidCpf(InvalidCpfException e) {
        StandardError err = StandardError.builder()
                .type(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getStatus()).body(err);
    }

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity<StandardError> notFoundCpf(NotFoundCpfException e) {
        StandardError err = StandardError.builder()
                .type(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(err);
    }
}
