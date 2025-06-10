package com.perfulandia.perfulandia_envio_api.dto;

import lombok.Data;

@Data

public class EnvioDTO {
    
    private Integer id_envio;
    private Integer id_venta;
    private Integer direccion_envio;
    private Integer estado_envio;
    private Integer fecha_envio;
    private Integer fecha_entrega;

    
}
