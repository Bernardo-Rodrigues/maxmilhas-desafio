package com.maxmilhas.desafio.api.unit.services;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import com.maxmilhas.desafio.api.services.impl.CpfServiceImpl;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
public class CpfServiceUnitTest implements WithAssertions {
    @InjectMocks
    private CpfServiceImpl service;
    @Mock
    private CpfRepository repository;
    @Mock
    private CpfMapper mapper;

    @Test
    void givenAListCpfsAttemptWhenThereAreNoCpfRegisteredThenReturnAnEmptyArray(){
        given(repository.findAll()).willReturn(new ArrayList<>());

        List<CpfDto> dtoList = service.list();

        assertThat(dtoList).isInstanceOf(LinkedList.class);
        assertThat(dtoList.size()).isZero();
    }
}
