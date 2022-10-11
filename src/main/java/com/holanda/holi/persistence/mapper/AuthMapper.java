package com.holanda.holi.persistence.mapper;

import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.persistence.entity.UsuarioEntity;
import org.springframework.security.core.userdetails.User;

public class AuthMapper {


    public static UsuarioEntity toUsuario(RegistroRequest registroRequest){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(registroRequest.getNombre());
        usuarioEntity.setUsername(registroRequest.getUsername());
        usuarioEntity.setEmail(registroRequest.getEmail());
        usuarioEntity.setPassword(registroRequest.getPassword());
        return usuarioEntity;
    }

    public static User toUserDetails(UsuarioEntity entity){
        return new User(
                entity.getEmail(),
                entity.getPassword(),
                entity.getAuthorities());
    }
}
