package com.utnmdp.aerolinea.Servicios;

import com.utnmdp.aerolinea.Repositorios.RutaRepositorio;
import com.utnmdp.aerolinea.entidades.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Ruta> verRutaOrigen (long id){
        return rutaRepositorio.getByInitAirport(id);
    }

    public Ruta agregarRuta (Ruta ruta){
     return rutaRepositorio.save(ruta);
    }

    public void  borrarRuta(long id){
        rutaRepositorio.deleteById(id);
    }

    public void actualizarRuta(long id, Ruta ruta){
        Optional<Ruta> porCambiar = this.dameUnaRuta(id);
        if(porCambiar != null){
            porCambiar.get().setId_aeropuerto_llegada(ruta.getId_aeropuerto_llegada());
            porCambiar.get().setId_aeropuerto_salida(ruta.getId_aeropuerto_salida());
            porCambiar.get().setDistancia(ruta.getDistancia());
            this.agregarRuta(porCambiar.get());

        }

    }

}
