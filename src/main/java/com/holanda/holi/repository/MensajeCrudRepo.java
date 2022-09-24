package com.holanda.holi.repository;

import com.holanda.holi.repository.entity.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeCrudRepo extends JpaRepository<MensajeEntity, Integer> {
}
