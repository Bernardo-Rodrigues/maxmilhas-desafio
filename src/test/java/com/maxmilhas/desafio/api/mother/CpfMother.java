package com.maxmilhas.desafio.api.mother;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.domain.request.CpfRequest;
import lombok.Data;

@Data
public class CpfMother {

    private static final String CPF_EXAMPLE = "43702611045";

    public static CpfRequest getCpfRequest(){
        return CpfRequest.builder()
                .cpf(CPF_EXAMPLE)
                .build();
    }

    public static CpfDto getCpfDto(){
        return CpfDto.builder()
                .cpf(CPF_EXAMPLE)
                .build();
    }

    public static Cpf getCpf(){
        return Cpf.builder()
                .cpf(CPF_EXAMPLE)
                .build();
    }
}
