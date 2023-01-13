package com.study.interceptor.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ValidaAutorizacaoUseCaseTest {
    @InjectMocks
    private ValidaAutorizacaoUseCase validaAutorizacaoUseCase;

    private String headerVazio = "";
    private String headerValido = "12349352600";
    private String headerNull = null;

    @Test
    public void autorizacaoVazia(){
        Boolean retornoEsperado = false;
        Boolean retornoObtido = validaAutorizacaoUseCase.execute(headerVazio);
        assertEquals(retornoObtido, retornoEsperado);
    }

    @Test
    public void autorizacaoNula(){
        Boolean retornoEsperado = false;
        Boolean retornoObtido = validaAutorizacaoUseCase.execute(headerNull);
        assertEquals(retornoObtido, retornoEsperado);
    }


    @Test
    public void autorizacaoValida(){
        Boolean retornoEsperado = true;
        Boolean retornoObtido = validaAutorizacaoUseCase.execute(headerValido);
        assertEquals(retornoObtido, retornoEsperado);
    }


}