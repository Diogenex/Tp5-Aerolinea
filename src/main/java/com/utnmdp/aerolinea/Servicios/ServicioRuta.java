package com.utnmdp.aerolinea.Servicios;

import com.utnmdp.aerolinea.Entidades.Ruta;
import com.utnmdp.aerolinea.Repositorios.RutaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioRuta {

    @Autowired
    RutaRepositorio rutaRepositorio;

    public Iterable<Ruta> dameRutas() {
        return rutaRepositorio.findAll();
    }

    public Optional<Ruta> dameUnaRuta(long id) {

        return  rutaRepositorio.findById(id);
    }

    public Ruta agregarRuta (Ruta ruta){
     return rutaRepositorio.save(ruta);
    }

    public void  borrarRuta(long id){
        rutaRepositorio.deleteById(id);
    }

    public void actualizarRuta(long id, Ruta ruta){
        Optional<Ruta> porCambiar = dameUnaRuta(id);
        if(porCambiar != null){
            porCambiar.get().setId_destino(ruta.getId_destino());
            porCambiar.get().setId_origen(ruta.getId_origen());
            porCambiar.get().setDistancia(ruta.getDistancia());
            this.agregarRuta(porCambiar.get());

        }

    }

}
