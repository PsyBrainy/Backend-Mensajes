package com.holanda.holi.mapper;

import com.holanda.holi.dto.MensajeDTO;
import com.holanda.holi.repository.entity.MensajeEntity;

import java.text.SimpleDateFormat;

public class MensajeMapper {

    public static MensajeDTO toMensajeDto(MensajeEntity entity){
        MensajeDTO productDto = new MensajeDTO();
        productDto.setTexto(entity.getTexto());
        productDto.setAutor(entity.getAutor());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy - hh:mm");

        productDto.setFecha(dateFormat.format(entity.getCreateOn()));

        return productDto;
    }

    public static MensajeEntity toMensajeEntity(MensajeDTO dto){
        MensajeEntity productEntity = new MensajeEntity();
        productEntity.setTexto(dto.getTexto());
        productEntity.setAutor(dto.getAutor());
        return productEntity;
    }
}
