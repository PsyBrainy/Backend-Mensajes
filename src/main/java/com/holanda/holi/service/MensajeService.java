package com.holanda.holi.service;

import com.holanda.holi.mapper.MensajeMapper;
import com.holanda.holi.dto.MensajeDTO;
import com.holanda.holi.repository.MensajeCrudRepo;
import com.holanda.holi.repository.entity.MensajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService {
    @Autowired
    private MensajeCrudRepo repo;

    public List<MensajeDTO> getAll() {

        return repo.findAll()
                .stream()
                .sorted(Comparator.comparing(MensajeEntity::getCreateOn))
                .map(MensajeMapper::toMensajeDto)
                .collect(Collectors.toList());
    }

    public MensajeDTO create(MensajeDTO productDto) {
        MensajeEntity entity = MensajeMapper.toMensajeEntity(productDto);
        return MensajeMapper.toMensajeDto(repo.save(entity));
    }
}
