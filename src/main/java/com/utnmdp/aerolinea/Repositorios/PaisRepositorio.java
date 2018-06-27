package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.entidades.Pais;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaisRepositorio extends CrudRepository<Pais, Long> {

    @Query(value = "SELECT p.* FROM pais p WHERE p.codigo_iso = :codigo", nativeQuery = true)
    Optional<Pais> findPaisByCodigoIso(@Param("codigo") String iso);

}
