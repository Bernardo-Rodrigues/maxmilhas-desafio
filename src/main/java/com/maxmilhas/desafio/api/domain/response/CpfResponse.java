package com.maxmilhas.desafio.api.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("CpfResponse")
public class CpfResponse {
    @ApiModelProperty(name = "cpf", value = "Cpf")
    private String cpf;

    @ApiModelProperty(name = "createdAt", value = "Data do registro")
    private LocalDateTime createdAt;
}
