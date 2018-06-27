package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.entidades.Aeropuerto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepositorio extends CrudRepository<Aeropuerto, Long> {
}
