package com.holanda.holi.persistence;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.dto.MensajeResponse;
import com.holanda.holi.domain.repository.MensajeRepository;
import com.holanda.holi.persistence.crud.MensajeCrudRepo;
import com.holanda.holi.persistence.entity.MensajeEntity;
import com.holanda.holi.persistence.mapper.MensajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Comparator;
import java.util.stream.Stream;

@Repository
public class MensajeRepositoryImpl implements MensajeRepository {

    @Autowired
    private MensajeCrudRepo repo;

    @Override
    public Stream<MensajeResponse> getAllMensajes() {

        return repo.findAll()
                .stream()
                .sorted(Comparator.comparing(MensajeEntity::getCreateOn).reversed())
                .map(MensajeMapper::toMensajeResponse);
    }

    @Override
    public MensajeResponse enviarMensaje(MensajeRequest mensajeRequest) {
        MensajeEntity entity = MensajeMapper.toMensajeEntity(mensajeRequest);
        return MensajeMapper.toMensajeResponse(repo.save(entity));
    }
}
