package com.perfulandia.perfulandia_envio_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnvioDTO {

    private Integer id_Envio;
    private Integer id_Venta;
    private String direccion_envio;
    private String estado_envio;
    private LocalDate fecha_envio;
    private LocalDate fecha_entrega;

}

