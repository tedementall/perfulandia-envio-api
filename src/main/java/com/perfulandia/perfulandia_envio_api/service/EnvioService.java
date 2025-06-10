package com.perfulandia.perfulandia_envio_api.service;

import com.perfulandia.perfulandia_envio_api.dto.EnvioDTO;
import com.perfulandia.perfulandia_envio_api.model.Envio;
import com.perfulandia.perfulandia_envio_api.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public EnvioDTO crearEnvio(EnvioDTO envioDTO) {
        Envio envio = toEntity(envioDTO);
        Envio envioGuardado = envioRepository.save(envio);
        return toDTO(envioGuardado);
    }

    public List<EnvioDTO> obtenerTodosLosEnvios() {
        List<Envio> envios = envioRepository.findAll();
        return envios.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EnvioDTO> obtenerEnvioPorId(Integer id) {
        Optional<Envio> envioOptional = envioRepository.findById(id);
        return envioOptional.map(this::toDTO);
    }

    public void eliminarEnvio(Integer id) {
        envioRepository.deleteById(id);
    }

    private EnvioDTO toDTO(Envio envio) {
        EnvioDTO dto = new EnvioDTO();
        dto.setId_Envio(envio.getIdEnvio());
        dto.setId_Venta(envio.getIdVenta());
        dto.setDireccion_envio(envio.getDireccionEnvio());
        dto.setEstado_envio(envio.getEstadoEnvio());
        dto.setFecha_envio(envio.getFechaEnvio());
        dto.setFecha_entrega(envio.getFechaEntrega());
        return dto;
    }

    private Envio toEntity(EnvioDTO envioDTO) {
        Envio envio = new Envio();
        envio.setIdEnvio(envioDTO.getId_Envio());
        envio.setIdVenta(envioDTO.getId_Venta());
        envio.setDireccionEnvio(envioDTO.getDireccion_envio());
        envio.setEstadoEnvio(envioDTO.getEstado_envio());
        envio.setFechaEnvio(envioDTO.getFecha_envio());
        envio.setFechaEntrega(envioDTO.getFecha_entrega());
        return envio;
    }
}
