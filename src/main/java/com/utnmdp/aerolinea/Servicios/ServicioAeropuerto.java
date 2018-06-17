package com.utnmdp.aerolinea.Servicios;


import com.utnmdp.aerolinea.Entidades.Aeropuerto;
import com.utnmdp.aerolinea.Entidades.Ciudad;
import com.utnmdp.aerolinea.Entidades.Pais;
import com.utnmdp.aerolinea.Entidades.Provincia;
import com.utnmdp.aerolinea.Repositorios.AeropuertoRepositorio;
import com.utnmdp.aerolinea.Repositorios.CiudadRepositorio;
import com.utnmdp.aerolinea.Repositorios.PaisRepositorio;
import com.utnmdp.aerolinea.Repositorios.ProvinciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAeropuerto {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public Iterable<Ciudad> dameCiudades ()
    {
        return ciudadRepositorio.findAll();
    }

    public Optional<Ciudad> dameUnaCiudad(long id){
        return ciudadRepositorio.findById(id);
    }


    @Autowired
    private PaisRepositorio paisRepositorio;

    public Iterable<Pais> damePaises ()
    {
        return paisRepositorio.findAll();
    }

    @Autowired
    private ProvinciaRepositorio provinciaRepositorio;

    public Iterable<Provincia> dameProvincias ()
    {
        return provinciaRepositorio.findAll();
    }


    @Autowired
    private AeropuertoRepositorio aeropuertoRepositorio;

    public List<Aeropuerto> dameAeropuertos ()
    {
        return (List<Aeropuerto>) aeropuertoRepositorio.findAll();
}

    public Optional<Aeropuerto> dameUnAeropuerto(long id){
        return aeropuertoRepositorio.findById(id);
    }

    public Aeropuerto agregarAeropuerto( Aeropuerto aeropuerto){
        return aeropuertoRepositorio.save(aeropuerto);
    }

    public void  borrarAeropuerto(long id){
         aeropuertoRepositorio.deleteById(id);
    }

    public void actualizarAeropuerto(long id, Aeropuerto aeropuerto){
         Optional<Aeropuerto> porCambiar = dameUnAeropuerto(id);
               if(porCambiar != null){
                  porCambiar.get().setCiudad(aeropuerto.getCiudad());
                  porCambiar.get().setCodigo_iata(aeropuerto.getCodigo_iata());
                  porCambiar.get().setNombre_aeropuerto(aeropuerto.getNombre_aeropuerto());
                  this.agregarAeropuerto(porCambiar.get());

               }

    }
}
