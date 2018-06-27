package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.entidades.Ciudad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CiudadRepositorio extends CrudRepository <Ciudad, Long> {

    @Query(value = "SELECT c.* FROM ciudad c  WHERE c.nombre_ciudad = :nombre", nativeQuery = true)
    Ciudad findCiudadByNombre(@Param("nombre") String iso);

}
