package com.maxmilhas.desafio.api.services.impl;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.maxmilhas.desafio.api.services.CpfValidatorService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CpfValidatorServiceImpl implements CpfValidatorService {

    CPFValidator cpfValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CpfValidatorServiceImpl.class);

    CpfValidatorServiceImpl(){
        this.setCpfValidator(new CPFValidator());
    }

    @Override
    public boolean isValid(String cpf) {
        List<ValidationMessage> errors = cpfValidator.invalidMessagesFor(cpf);

        if(errors.size() > 0){
            LOGGER.info("Cpf is not valid: " + errors);
            return false;
        }

        return true;
    }
}
