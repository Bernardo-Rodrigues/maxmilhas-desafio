package com.maxmilhas.desafio.api.repositories;

import com.maxmilhas.desafio.api.domain.entities.Cpf;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CpfRepository extends MongoRepository<Cpf, String> {
}
