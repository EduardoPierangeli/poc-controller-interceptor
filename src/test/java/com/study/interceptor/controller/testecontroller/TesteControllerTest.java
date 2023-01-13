package com.study.interceptor.controller.testecontroller;

import com.study.interceptor.usecase.ValidaAutorizacaoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Objects;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TesteController.class)
class TesteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValidaAutorizacaoUseCase useCase;

    @Test
    void testeComHeaderValidoDeveRetornar200OK() throws Exception {
        when(useCase.execute(anyString())).thenReturn(true);
        this.mockMvc.perform(factoryRequest("/teste", "12349352690"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("200 OK")));
    }

    @Test
    void testeComHeaderVazioNaoDeveRetornarNada() throws Exception {
        when(useCase.execute(anyString())).thenReturn(true);
        this.mockMvc.perform(factoryRequest("/teste", ""))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    void testeComHeaderNuloNaoDeveRetornarNada() throws Exception {
        when(useCase.execute(anyString())).thenReturn(true);
        this.mockMvc.perform(factoryRequest("/teste", null))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
    private MockHttpServletRequestBuilder factoryRequest(String url, String headerValue) {
        if(Objects.isNull(headerValue) || headerValue.isEmpty()){
            return MockMvcRequestBuilders.get(url);
        }
        return MockMvcRequestBuilders.get(url)
                .header("Authorization", headerValue);
    }

}