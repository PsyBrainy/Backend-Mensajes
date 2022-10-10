package com.holanda.holi.persistence.mapper;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.dto.MensajeResponse;
import com.holanda.holi.domain.utils.DateFormatUtil;
import com.holanda.holi.persistence.entity.MensajeEntity;

public class MensajeMapper {

    public static MensajeResponse toMensajeResponse(MensajeEntity entity){
        MensajeResponse dto = new MensajeResponse();
        dto.setTexto(entity.getTexto());
        dto.setAutor(entity.getAutor());
        dto.setFecha(DateFormatUtil.toCustomDate(entity.getCreateOn()));
        return dto;
    }

    public static MensajeEntity toMensajeEntity(MensajeRequest mensajeRequest){
        MensajeEntity entity = new MensajeEntity();
        entity.setTexto(mensajeRequest.getTexto());
        entity.setAutor(mensajeRequest.getAutor());
        return entity;
    }
}
