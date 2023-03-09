package com.maxmilhas.desafio.api.services.impl;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.domain.exception.ExistsCpfException;
import com.maxmilhas.desafio.api.domain.exception.InvalidCpfException;
import com.maxmilhas.desafio.api.domain.exception.NotFoundCpfException;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import com.maxmilhas.desafio.api.services.CpfService;
import com.maxmilhas.desafio.api.services.CpfValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CpfServiceImpl implements CpfService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpfValidatorServiceImpl.class);

    @Autowired
    CpfRepository cpfRepository;
    @Autowired
    CpfValidatorService cpfValidatorService;
    @Autowired
    CpfMapper mapper;

    @Override
    public List<CpfDto> list() {
        List<CpfDto> dtoList = mapper.entityListToDtoList(cpfRepository.findAll());

        LOGGER.info("Returning list of cpfs: {" + dtoList + "}");
        return dtoList ;
    }

    @Override
    public CpfDto get(String cpf) {
        LOGGER.info("Trying to get cpf {" + cpf + "}");

        if(!cpfValidatorService.isValid(cpf)) throw new InvalidCpfException();

        CpfDto dto = mapper.entityToDto(
                cpfRepository.findCpfByCpf(cpf).orElseThrow(NotFoundCpfException::new)
        );
        LOGGER.info("Returning cpf: {" + dto + "}");

        return dto;
    }

    @Override
    public void delete(String cpf) {
        CpfDto dto = this.get(cpf);

        cpfRepository.deleteById(dto.getId());

        LOGGER.info("Cpf with id {" + dto.getId() + "} deleted");
    }

    @Override
    public CpfDto create(CpfDto dto) {
        LOGGER.info("Trying to save cpf {" + dto.getCpf() + "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        if(!cpfValidatorService.isValid(dto.getCpf())) throw new InvalidCpfException();

        if(cpfRepository.findCpfByCpf(dto.getCpf()).isPresent()) throw new ExistsCpfException();

        Cpf entity = Cpf.builder()
                .cpf(dto.getCpf())
                .createdAt(OffsetDateTime.now(ZoneOffset.UTC).format(formatter))
                .build();

        CpfDto savedDto = mapper.entityToDto(cpfRepository.save(entity));
        LOGGER.info("Cpf " + savedDto + " was saved");

        return savedDto;
    }
}
