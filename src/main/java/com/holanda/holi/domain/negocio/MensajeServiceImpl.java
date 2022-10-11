package com.holanda.holi.domain.negocio;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.repository.MensajeRepository;
import com.holanda.holi.domain.dto.MensajeResponse;
import com.holanda.holi.web.service.MensajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeServiceImpl implements MensajesService {

    @Autowired
    private MensajeRepository mensajeRepository;


    @Override
    public List<MensajeResponse> getAllMensajes() {
        return mensajeRepository.getAllMensajes().collect(Collectors.toList());
    }

    @Override
    public MensajeResponse enviarMensaje(MensajeRequest mensajeRequest) {
        return mensajeRepository.enviarMensaje(mensajeRequest);
    }

    @Override
    public MensajeResponse borrarMensaje(Integer id) {
        return mensajeRepository.deleteMensaje(id);
    }
}
