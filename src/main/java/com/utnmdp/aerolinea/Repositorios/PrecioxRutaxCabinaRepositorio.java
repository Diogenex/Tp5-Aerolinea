package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.entidades.PrecioxRutaxCabina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioxRutaxCabinaRepositorio extends CrudRepository<PrecioxRutaxCabina, Long> {

    @Query(value = "SELECT * FROM precio_ruta_cabina  r WHERE r.id_ruta = :id_ruta" ,
            nativeQuery = true)
    List<PrecioxRutaxCabina> getByPrecioxRuta(@Param("id_ruta") long id);
}
