package com.holanda.holi.controller;


import com.holanda.holi.dto.AuthenticationResponse;
import com.holanda.holi.dto.LoginDTO;
import com.holanda.holi.dto.RegistroDTO;
import com.holanda.holi.repository.RolRepository;
import com.holanda.holi.repository.UsuarioRepository;
import com.holanda.holi.repository.entity.Rol;
import com.holanda.holi.repository.entity.Usuario;
import com.holanda.holi.security.CustomUserDetailsService;
import com.holanda.holi.security.JWTUtil;
import com.holanda.holi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthService service;

    @PostMapping("/iniciarSesion")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody LoginDTO loginDTO){
        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsernameOrEmail());

            String jwt = jwtUtil.generateToken(userDetails);
            SecurityContextHolder.getContext().setAuthentication(authentication); // TODO Sacar esto

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario (@RequestBody RegistroDTO registroDTO) {
        service.registrarUsuario(registroDTO);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
    }
}