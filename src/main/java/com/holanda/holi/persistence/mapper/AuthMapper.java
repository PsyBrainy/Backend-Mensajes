package com.holanda.holi.persistence.mapper;

import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.persistence.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthMapper {

    @Autowired
    private static PasswordEncoder passwordEncoder;


    public static UsuarioEntity toUsuario(RegistroRequest registroRequest){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(registroRequest.getNombre());
        usuarioEntity.setUsername(registroRequest.getUsername());
        usuarioEntity.setEmail(registroRequest.getEmail());
        usuarioEntity.setPassword(passwordEncoder.encode(registroRequest.getPassword()));
        return usuarioEntity;
    }

    public static User toUserDetails(UsuarioEntity entity){
        return new User(
                entity.getEmail(),
                entity.getPassword(),
                entity.getAuthorities());
    }
}
