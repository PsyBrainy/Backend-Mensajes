package com.holanda.holi.domain.repository;

import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.persistence.entity.UsuarioEntity;

public interface AuthRepository {

    void saveUser(RegistroRequest registroRequest, String rol);

    UsuarioEntity findByEmail(String username);

}
