package com.study.interceptor.config;

import com.study.interceptor.controller.testecontroller.TesteControllerInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@RequiredArgsConstructor
@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
    private final TesteControllerInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
