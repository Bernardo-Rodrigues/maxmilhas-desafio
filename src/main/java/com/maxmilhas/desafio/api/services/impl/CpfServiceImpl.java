package com.maxmilhas.desafio.api.services.impl;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import com.maxmilhas.desafio.api.services.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfServiceImpl implements CpfService {
    @Autowired
    CpfRepository cpfRepository;
    @Autowired
    CpfMapper mapper;

    @Override
    public List<CpfDto> list() {
        return mapper.entityListToDtoList(cpfRepository.findAll());
    }
}
