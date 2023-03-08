package com.maxmilhas.desafio.api.services;


import com.maxmilhas.desafio.api.domain.dto.CpfDto;

import java.util.List;

public interface CpfService {
    List<CpfDto> list();
    CpfDto get(String cpf);
    void delete(String cpf);
}
