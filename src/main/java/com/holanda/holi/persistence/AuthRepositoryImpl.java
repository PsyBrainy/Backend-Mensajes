package com.holanda.holi.persistence;

import com.holanda.holi.domain.dto.RegistroRequest;
import com.holanda.holi.domain.repository.AuthRepository;
import com.holanda.holi.persistence.crud.RolCrudRepo;
import com.holanda.holi.persistence.crud.UsuarioCrudRepo;
import com.holanda.holi.persistence.entity.RolEntity;
import com.holanda.holi.persistence.entity.UsuarioEntity;
import com.holanda.holi.persistence.mapper.AuthMapper;
import com.holanda.holi.web.exceptions.custom.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    @Autowired
    private UsuarioCrudRepo usuarioCrudRepo;

    @Autowired
    private RolCrudRepo rolCrudRepo;

    @Override
    public void saveUser(RegistroRequest registroRequest, String rol){
        if (usuarioCrudRepo.existsByUsername(registroRequest.getUsername()))  {
            throw new InvalidDataException("Ese nombre de usuario ya existe");
        }
        if (usuarioCrudRepo.existsByEmail(registroRequest.getEmail()))  {
            throw new InvalidDataException("Ese email de usuario ya existe");
        }
        RolEntity rolEntity = rolCrudRepo.findByNombre(rol)
                .orElseThrow(()-> new InvalidDataException("No se encontro ese rol"));

        UsuarioEntity usuarioEntity = AuthMapper.toUsuario(registroRequest);


        usuarioEntity.setRoles(Set.of(rolEntity));
        usuarioCrudRepo.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity findByEmail(String username){
        return usuarioCrudRepo.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese username o email: " + username));
    }

}
