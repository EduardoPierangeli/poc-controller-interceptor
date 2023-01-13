package com.study.interceptor.usecase;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Log
@Component
public class ValidaAutorizacaoUseCase {
    public boolean execute(String authorization){
        if(Objects.isNull(authorization) || authorization.isEmpty()){
            log.info("O Header Authorization está vazio, e por isso a requisição não prosseguiu para a controller.");
            return false;
        }
        log.info("Header preenchido, prosseguindo com a requisição para a controller...");
        return true;
    }
}
