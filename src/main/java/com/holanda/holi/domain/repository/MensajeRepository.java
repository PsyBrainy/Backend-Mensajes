package com.holanda.holi.domain.repository;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.dto.MensajeResponse;

import java.util.stream.Stream;

public interface MensajeRepository {

    Stream<MensajeResponse> getAllMensajes();

    MensajeResponse enviarMensaje(MensajeRequest mensajeRequest);

    MensajeResponse deleteMensaje(Integer id);
}
