package com.utnmdp.aerolinea.Servicios;

import com.utnmdp.aerolinea.Repositorios.PrecioxRutaxCabinaRepositorio;
import com.utnmdp.aerolinea.entidades.PrecioxRutaxCabina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPrecioxRutaxCabina {

    @Autowired
    PrecioxRutaxCabinaRepositorio precioxRutaxCabinaRepositorio;

    public Iterable<PrecioxRutaxCabina> damePrecios() {
        return precioxRutaxCabinaRepositorio.findAll();
    }

    public Optional<PrecioxRutaxCabina> dameUnPrecio(long id) {

        return  precioxRutaxCabinaRepositorio.findById(id);
    }
    public List<PrecioxRutaxCabina> damePrecioPorRuta(long id){
        return precioxRutaxCabinaRepositorio.getByPrecioxRuta(id);
    }
    public PrecioxRutaxCabina agregarPrecio (PrecioxRutaxCabina precio){
        return precioxRutaxCabinaRepositorio.save(precio);
    }

    public void  borrarPrecio(long id){
        precioxRutaxCabinaRepositorio.deleteById(id);
    }

    public void actualizarPrecio(long id, PrecioxRutaxCabina precio){
        Optional<PrecioxRutaxCabina> porCambiar = this.dameUnPrecio(id);
        if(porCambiar != null){
            porCambiar.get().setId_ruta_fk(precio.getId_ruta_fk());
            porCambiar.get().setPrecio(precio.getPrecio());
            porCambiar.get().setVigencia_desde(precio.getVigencia_desde());
            porCambiar.get().setVigencia_hasta(precio.getVigencia_desde());
            this.agregarPrecio(porCambiar.get());

        }

    }
}
