package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.Entidades.PrecioxRutaxCabina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioxRutaxCabinaRepositorio extends CrudRepository<PrecioxRutaxCabina, Long> {
}
