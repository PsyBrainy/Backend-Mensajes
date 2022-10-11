package com.holanda.holi.persistence.crud;

import com.holanda.holi.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioCrudRepo extends JpaRepository<UsuarioEntity, Long> {
    public Optional<UsuarioEntity> findByEmail (String email);

    public Optional<UsuarioEntity> findByUsernameOrEmail (String username, String email);

    public Optional<UsuarioEntity> findByUsername (String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail (String email);
}
