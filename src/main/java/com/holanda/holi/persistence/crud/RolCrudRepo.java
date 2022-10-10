package com.holanda.holi.persistence.crud;

import com.holanda.holi.persistence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolCrudRepo extends JpaRepository<RolEntity, Long> {

    Optional<RolEntity> findByNombre (String nombre);
}
