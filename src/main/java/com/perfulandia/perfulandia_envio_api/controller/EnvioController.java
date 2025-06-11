package com.perfulandia.perfulandia_envio_api.controller;

import com.perfulandia.perfulandia_envio_api.dto.EnvioDTO;
import com.perfulandia.perfulandia_envio_api.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping
    public ResponseEntity<EnvioDTO> crearEnvio(@RequestBody EnvioDTO envioDTO) {
        EnvioDTO nuevoEnvio = envioService.crearEnvio(envioDTO);
        return ResponseEntity.ok(nuevoEnvio);
    }

    @GetMapping
    public ResponseEntity<List<EnvioDTO>> obtenerTodosLosEnvios() {
        List<EnvioDTO> envios = envioService.obtenerTodosLosEnvios();
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> obtenerEnvioPorId(@PathVariable Integer id) {
        Optional<EnvioDTO> envioOptional = envioService.obtenerEnvioPorId(id);
        return envioOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEnvio(@PathVariable Integer id) {
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}

