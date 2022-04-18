package com.examencerticom.controller;

import com.examencerticom.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/venta")
public class VentaController {

    private final IVentaService iVentaService;    
    
    public VentaController(IVentaService iVentaService) {
        this.iVentaService = iVentaService;
    }

    @GetMapping("")
    public ResponseEntity<?> listarVentasFiltrado(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam(required = true, defaultValue = "1") Integer pagina,
            @RequestParam(required = true, defaultValue = "5") Integer tamanio) {
        try {            
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.iVentaService.listarVentasFiltrado(fecha, pagina, tamanio));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
