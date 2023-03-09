package com.maxmilhas.desafio.api.controllers;

import com.maxmilhas.desafio.api.domain.dto.CpfDto;
import com.maxmilhas.desafio.api.domain.mapper.CpfMapper;
import com.maxmilhas.desafio.api.domain.request.CpfRequest;
import com.maxmilhas.desafio.api.domain.response.CpfResponse;
import com.maxmilhas.desafio.api.services.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping("/{cpf}")
    public ResponseEntity delete (@PathVariable String cpf){
        service.delete(cpf);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity create (@RequestBody CpfRequest body){
        CpfDto dto = service.create(mapper.requestToDto(body));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
