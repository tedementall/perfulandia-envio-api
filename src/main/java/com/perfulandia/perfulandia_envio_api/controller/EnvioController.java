package com.perfulandia.perfulandia_envio_api.controller;

import com.perfulandia.perfulandia_envio_api.dto.EnvioDTO;
import com.perfulandia.perfulandia_envio_api.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/hateoas/{id}")
    public ResponseEntity<EnvioDTO> obtenerHATEOAS(@PathVariable Integer id) {
        Optional<EnvioDTO> envioOptional = envioService.obtenerEnvioPorId(id);

        if (envioOptional.isPresent()) {
            EnvioDTO dto = envioOptional.get();
            dto.add(Link.of("http://localhost:8888/api/proxy/envios/" + dto.getId()).withSelfRel());
            dto.add(Link.of("http://localhost:8888/api/proxy/envios/" + dto.getId()).withRel("Modificar HATEOAS").withType("PUT"));
            dto.add(Link.of("http://localhost:8888/api/proxy/envios/" + dto.getId()).withRel("Eliminar HATEOAS").withType("DELETE"));
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/hateoas")
    public List<EnvioDTO> obtenerTodosHATEOAS() {
        List<EnvioDTO> lista = envioService.obtenerTodosLosEnvios();

        for (EnvioDTO dto : lista) {
    
            dto.add(Link.of("http://localhost:8888/api/proxy/envios").withRel("Get todos HATEOAS"));
            dto.add(Link.of("http://localhost:8888/api/proxy/envios/" + dto.getId()).withRel("Crear HATEOAS").withType("POST"));
        }

        return lista;
    }
}

