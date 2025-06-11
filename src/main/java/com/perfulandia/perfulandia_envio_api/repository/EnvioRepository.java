package com.perfulandia.perfulandia_envio_api.repository;

import com.perfulandia.perfulandia_envio_api.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {

}