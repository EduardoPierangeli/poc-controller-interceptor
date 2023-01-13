package com.study.interceptor.controller.testecontroller;

import com.study.interceptor.usecase.ValidaAutorizacaoUseCase;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Objects;

@Log
@Component
public class TesteControllerInterceptor implements HandlerInterceptor {
    @Autowired
    ValidaAutorizacaoUseCase validaAutorizacaoUseCase;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        log.info("Requisição interceptada... Authorization: " + authorization);

        return validaAutorizacaoUseCase.execute(authorization);
    }
}
