package com.holanda.holi.domain.negocio;

import com.holanda.holi.domain.dto.AuthenticationResponse;
import com.holanda.holi.domain.dto.AuthenticationRequest;
import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.domain.repository.AuthRepository;
import com.holanda.holi.web.security.CustomUserDetailsSevice;
import com.holanda.holi.web.service.AuthService;
import com.holanda.holi.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService  {

    @Autowired
    private AuthRepository repository;

    @Autowired
    private CustomUserDetailsSevice userDetailsSevice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest){

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsernameOrEmail(), authenticationRequest.getPassword()));
            UserDetails userDetails = userDetailsSevice.loadUserByUsername(authenticationRequest.getUsernameOrEmail());
            String jwt = jwtUtil.generateToken(userDetails);

            return new AuthenticationResponse(jwt);
    }

    @Override
    public void registrarUsuario(RegistroRequest registroRequest){
        String rol = registroRequest.getNombre().equalsIgnoreCase("admin") ? "ROLE_ADMIN" : "ROLE_USER";
        repository.saveUser(registroRequest, rol);
    }
}
