package com.holanda.holi.service;

import com.holanda.holi.dto.RegistroDTO;
import com.holanda.holi.repository.RolRepository;
import com.holanda.holi.repository.UsuarioRepository;
import com.holanda.holi.repository.entity.Rol;
import com.holanda.holi.repository.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrarUsuario(RegistroDTO registroDTO){
//        if (usuarioRepository.existsByUsername(registroDTO.getUsername()))  {
//            return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
//        }
//        if (usuarioRepository.existsByEmail(registroDTO.getEmail()))  {
//            return new ResponseEntity<>("Ese email de usuario ya existe", HttpStatus.BAD_REQUEST);
//        }

        Usuario usuario = new Usuario();
        usuario.setNombre(registroDTO.getNombre());
        usuario.setUsername(registroDTO.getUsername());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

        String rol = registroDTO.getNombre().equals("admin") ? "ROLE_ADMIN" : "ROLE_USER";

        usuario.setRoles(Collections.singleton(rolRepository.findByNombre(rol).orElseThrow()));
        usuarioRepository.save(usuario);
    }
}
