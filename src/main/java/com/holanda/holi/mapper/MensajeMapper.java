package com.holanda.holi.mapper;

import com.holanda.holi.model.MensajeDto;
import com.holanda.holi.repository.entity.MensajeEntity;

import java.text.SimpleDateFormat;

public class MensajeMapper {

    public static MensajeDto toMensajeDto(MensajeEntity entity){
        MensajeDto productDto = new MensajeDto();
        productDto.setTexto(entity.getTexto());
        productDto.setAutor(entity.getAutor());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy - hh:mm");

        productDto.setFecha(dateFormat.format(entity.getCreateOn()));

        return productDto;
    }

    public static MensajeEntity toMensajeEntity(MensajeDto dto){
        MensajeEntity productEntity = new MensajeEntity();
        productEntity.setTexto(dto.getTexto());
        productEntity.setAutor(dto.getAutor());
        return productEntity;
    }
}
