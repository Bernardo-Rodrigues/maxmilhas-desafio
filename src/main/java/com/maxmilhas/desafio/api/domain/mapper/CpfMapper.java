package com.maxmilhas.desafio.api.domain.mapper;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.domain.response.CpfResponse;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface CpfMapper {
    List<CpfDto> entityListToDtoList(List<Cpf> entityList);
    List<CpfResponse> dtoListToResponseList(List<CpfDto> dtoList);
    CpfDto entityToDto(Cpf entity);
    CpfResponse dtoToResponse(CpfDto dto);

    Cpf dtoToEntity(CpfDto dto);
}
