package com.holanda.holi.web.controller;


import com.holanda.holi.domain.dto.AuthenticationResponse;
import com.holanda.holi.domain.dto.AuthenticationRequest;
import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.web.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/iniciarSesion")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<>(service.authenticateUser(authenticationRequest), HttpStatus.ACCEPTED);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario (@RequestBody RegistroRequest registroRequest) {
        service.registrarUsuario(registroRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}