package com.holanda.holi.web.service;

import com.holanda.holi.domain.dto.AuthenticationResponse;
import com.holanda.holi.domain.dto.AuthenticationRequest;
import com.holanda.holi.domain.dto.RegistroRequest;

public interface AuthService {

    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);

    void registrarUsuario(RegistroRequest registroRequest);

}
