package com.maxmilhas.desafio.api.services.impl;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import com.maxmilhas.desafio.api.services.CpfService;
import com.maxmilhas.desafio.api.services.CpfValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfServiceImpl implements CpfService {
    @Autowired
    CpfRepository cpfRepository;
    @Autowired
    CpfValidatorService cpfValidatorService;
    @Autowired
    CpfMapper mapper;

    @Override
    public List<CpfDto> list() {
        return mapper.entityListToDtoList(cpfRepository.findAll());
    }

    @Override
    public CpfDto get(String cpf) {
        if(cpfValidatorService.isValid(cpf)) System.out.println("Is valid");
        else throw new RuntimeException("Cpf invalid");
        Cpf entity = cpfRepository.findCpfByCpf(cpf).orElseThrow();
        return mapper.entityToDto(entity);
    }
}
