package com.utnmdp.aerolinea.Servicios;


import com.utnmdp.aerolinea.Entidades.Cabina;
import com.utnmdp.aerolinea.Repositorios.CabinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ServicioCabinas {

    @Autowired
    private CabinaRepositorio cabinaRepositorio;

    public Collection<Cabina> dameCabinas(){
        return cabinaRepositorio.findAll();
    }

    public Cabina agregarCabina(Cabina cabina) {
        return cabinaRepositorio.save(cabina);
    }

    public boolean verExistencia(long id){
       return cabinaRepositorio.existsById(id);
    }

    public Optional<Cabina> unaCabina(long id){
        return cabinaRepositorio.findById(id);
    }

    public void eliminarCabina(long id){
        cabinaRepositorio.deleteById(id);
    }

}
