package com.holanda.holi.controller;

import com.holanda.holi.dto.MensajeDTO;
import com.holanda.holi.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MensajeController {

    @Autowired
    private MensajeService service;

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    @GetMapping ("/mensaje")
    public ResponseEntity<List<MensajeDTO>> getAllMensajes(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.106:3000", "http://localhost:3001", "http://192.168.0.64:3000", "http://192.168.0.64:3001"})
    //@PreAuthorize("hasRole('ADMIN')")
   @PostMapping
    public ResponseEntity<MensajeDTO> createMensaje(@RequestBody MensajeDTO productDto){
        return new ResponseEntity<>(service.create(productDto), HttpStatus.CREATED);
    }
}