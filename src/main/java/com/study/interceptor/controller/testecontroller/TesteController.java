package com.study.interceptor.controller.testecontroller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@Log
@RestController
public class TesteController {
    @GetMapping("/teste")
    public String healthCheck(@RequestHeader(value = "Authorization", required = false) String senha){
        log.info("Request recebida no endpoint:  /teste");
        log.info("Header: " + senha);
        return ("200 OK");
    }
}
