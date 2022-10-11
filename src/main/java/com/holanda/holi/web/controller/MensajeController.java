package com.holanda.holi.web.controller;

import com.holanda.holi.domain.dto.MensajeRequest;
import com.holanda.holi.domain.dto.MensajeResponse;
import com.holanda.holi.web.service.MensajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensaje")
public class MensajeController {

    @Autowired
    private MensajesService service;

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @GetMapping
    public ResponseEntity<List<MensajeResponse>> getAllMensajes(){
        return new ResponseEntity<>(service.getAllMensajes(), HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @PostMapping
    public ResponseEntity<MensajeResponse> enviarMensaje(@RequestBody MensajeRequest mensajeRequest){
        return new ResponseEntity<>(service.enviarMensaje(mensajeRequest), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MensajeResponse> removeMensaje(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(service.borrarMensaje(id), HttpStatus.OK );
    }
}