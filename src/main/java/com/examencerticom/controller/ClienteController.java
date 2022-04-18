package com.examencerticom.controller;

import com.examencerticom.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examencerticom.entidades.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clienteService.findAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clienteService.findById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cliente entity) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.clienteService.save(entity));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
