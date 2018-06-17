package com.utnmdp.aerolinea.Repositorios;

import com.utnmdp.aerolinea.Entidades.Cabina;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Collections;

public interface CabinaRepositorio extends CrudRepository<Cabina, Long> {
    Collection<Cabina> findAll();
}
