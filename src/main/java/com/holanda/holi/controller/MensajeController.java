package com.holanda.holi.controller;

import com.holanda.holi.model.MensajeDto;
import com.holanda.holi.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService service;

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @GetMapping
    public ResponseEntity<List<MensajeDto>> getAllMensajes(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @PostMapping
    public ResponseEntity<MensajeDto> createMensaje(@RequestBody MensajeDto productDto){

        return new ResponseEntity<>(service.create(productDto), HttpStatus.CREATED);
    }
}
