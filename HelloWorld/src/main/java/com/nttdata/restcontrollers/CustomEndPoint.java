package com.nttdata.restcontrollers;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RestControllerEndpoint(id = "controller-end-point")
public class CustomEndPoint {
    @GetMapping("/my-endpoint")
    public @ResponseBody ResponseEntity<String> customEndPoint(){
        return  new ResponseEntity<>("Hola soy tu Endpoint customizado", HttpStatus.OK);
    }
}
