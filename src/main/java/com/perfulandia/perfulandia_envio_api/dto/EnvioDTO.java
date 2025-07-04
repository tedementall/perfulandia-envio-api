package com.perfulandia.perfulandia_envio_api.dto;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO extends RepresentationModel <EnvioDTO> {

    private Integer id_Envio;
    private Integer id_Venta;
    private String direccion_envio;
    private String estado_envio;
    private LocalDate fecha_envio;
    private LocalDate fecha_entrega;

    public Integer getId() {
    return this.id_Envio;
}

}

