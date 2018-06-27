package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.entidades.Ruta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RutaRepositorio extends CrudRepository<Ruta, Long> {

    @Query( value = "SELECT * FROM ruta r WHERE r.id_aeropuerto_salida = :aeropuertoSalida",
            nativeQuery = true)
    List<Ruta> getByInitAirport(@Param("aeropuertoSalida") long id);
}
