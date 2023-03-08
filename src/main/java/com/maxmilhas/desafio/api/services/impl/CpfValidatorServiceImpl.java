package com.maxmilhas.desafio.api.services.impl;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.maxmilhas.desafio.api.services.CpfValidatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfValidatorServiceImpl implements CpfValidatorService {

    CPFValidator cpfValidator;

    CpfValidatorServiceImpl(){
        this.cpfValidator = new CPFValidator();
    }

    @Override
    public boolean isValid(String cpf) {
        List<ValidationMessage> errors = cpfValidator.invalidMessagesFor(cpf);

        if(errors.size() > 0){
            System.out.println(errors);
            return false;
        }

        return true;
    }
}
