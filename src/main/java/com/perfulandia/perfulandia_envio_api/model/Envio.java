package com.perfulandia.perfulandia_envio_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "envios")
@Data

public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;

    @Column(name = "id_venta", nullable = false)
    private Integer idVenta;

    @Column(name = "direccion_envio", nullable = false)
    private String direccionEnvio;

    @Column(name = "estado_envio", nullable = false)
    private String estadoEnvio;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDate fechaEnvio;

    @Column(name = "fecha_entrega", nullable = true)
    private LocalDate fechaEntrega;

}
