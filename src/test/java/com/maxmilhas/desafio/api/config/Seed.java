package com.maxmilhas.desafio.api.config;

import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class Seed implements CommandLineRunner {

    @Autowired
    CpfRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Cpf cpf1 = Cpf.builder().cpf("70525056068").createdAt(LocalDateTime.now()).build();
        Cpf cpf2 = Cpf.builder().cpf("39802371092").createdAt(LocalDateTime.now()).build();

        repository.saveAll(Arrays.asList(cpf1, cpf2));
    }
}
