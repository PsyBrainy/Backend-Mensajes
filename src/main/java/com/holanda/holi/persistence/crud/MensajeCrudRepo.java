package com.holanda.holi.persistence.crud;

import com.holanda.holi.persistence.entity.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeCrudRepo extends JpaRepository<MensajeEntity, Integer> {
}
