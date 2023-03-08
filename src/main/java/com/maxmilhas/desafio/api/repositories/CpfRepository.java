package com.maxmilhas.desafio.api.repositories;

import com.maxmilhas.desafio.api.domain.entities.Cpf;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CpfRepository extends MongoRepository<Cpf, String> {
    Optional<Cpf> findCpfByCpf(String cpf);
}
