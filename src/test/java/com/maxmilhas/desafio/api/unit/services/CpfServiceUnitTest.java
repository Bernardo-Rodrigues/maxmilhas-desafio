package com.maxmilhas.desafio.api.unit.services;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.exception.InvalidCpfException;
import com.maxmilhas.desafio.api.domain.exception.NotFoundCpfException;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import com.maxmilhas.desafio.api.services.CpfValidatorService;
import com.maxmilhas.desafio.api.services.impl.CpfServiceImpl;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
public class CpfServiceUnitTest implements WithAssertions {

    private static final String CPF_EXAMPLE = "42305544006";

    @InjectMocks
    private CpfServiceImpl cpfService;
    @Mock
    private CpfValidatorService cpfValidatorService;
    @Mock
    private CpfRepository repository;
    @Mock
    private CpfMapper mapper;

    @Test
    void givenAListCpfsAttemptWhenThereAreNoCpfRegisteredThenReturnAnEmptyArray(){
        given(repository.findAll()).willReturn(new ArrayList<>());

        List<CpfDto> dtoList = cpfService.list();

        assertThat(dtoList).isInstanceOf(LinkedList.class);
        assertThat(dtoList.size()).isZero();
    }

    @Test
    void givenAGetCpfAttemptWhenTheCpfRequestedIsInvalidThenThrowAInvalidCpfException(){
        given(cpfValidatorService.isValid(CPF_EXAMPLE)).willReturn(false);

        assertThatThrownBy(() -> cpfService.get(CPF_EXAMPLE)).isInstanceOf(InvalidCpfException.class);
    }

    @Test
    void givenAGetCpfAttemptWhenThereAreNoCpfRegisteredThenThrowANotFoundCpfException(){
        given(cpfValidatorService.isValid(CPF_EXAMPLE)).willReturn(true);
        given(repository.findCpfByCpf(CPF_EXAMPLE)).willReturn(Optional.empty());

        assertThatThrownBy(() -> cpfService.get(CPF_EXAMPLE)).isInstanceOf(NotFoundCpfException.class);
    }
}
