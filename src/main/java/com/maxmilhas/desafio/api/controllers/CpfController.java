package com.maxmilhas.desafio.api.controllers;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.domain.response.CpfResponse;
import com.maxmilhas.desafio.api.services.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpf")
public class CpfController {

    @Autowired
    CpfService service;
    @Autowired
    CpfMapper mapper;

    @GetMapping
    public ResponseEntity<List<CpfResponse>> list (){
        List<CpfDto> dtoList = service.list();
        return ResponseEntity.ok().body(mapper.dtoListToResponseList(dtoList));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CpfResponse> get (@PathVariable String cpf){
        CpfDto dto = service.get(cpf);
        return ResponseEntity.ok().body(mapper.dtoToResponse(dto));
    }
}
