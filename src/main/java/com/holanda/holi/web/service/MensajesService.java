package com.holanda.holi.web.service;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.dto.MensajeResponse;

import java.util.List;

public interface MensajesService {

    List<MensajeResponse> getAllMensajes();

    MensajeResponse enviarMensaje(MensajeRequest mensajeRequest);
}
