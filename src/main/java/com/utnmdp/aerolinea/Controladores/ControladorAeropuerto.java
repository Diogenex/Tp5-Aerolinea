package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Entidades.Aeropuerto;
import com.utnmdp.aerolinea.Entidades.Ciudad;
import com.utnmdp.aerolinea.Entidades.Pais;
import com.utnmdp.aerolinea.Entidades.Provincia;
import com.utnmdp.aerolinea.Servicios.ServicioAeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControladorAeropuerto {


        @Autowired
        private ServicioAeropuerto servicioAeropuerto;


    //------------------- Ver Ciudades ------------------------------------------------------------------

        @GetMapping(path = "/Ciudad")
        public @ResponseBody
        Iterable<Ciudad> Ciudades() {
                return servicioAeropuerto.dameCiudades();
        }


    //------------------- Ver Ciudad por id -------------------------------------------------------------

        @GetMapping(path = "/Ciudad/{id}")
        public @ResponseBody
        Optional<Ciudad> Ciudades(@PathVariable long id) {
                return servicioAeropuerto.dameUnaCiudad(id);
        }


        //------------------------ Ver Paises ----------------------------------------------------------------


        @GetMapping(path = "/Pais")
        public @ResponseBody
        Iterable<Pais> Paises() {
                return servicioAeropuerto.damePaises();
        }


    //------------------- Ver Provincias --------------------------------------------------------


        @GetMapping(path = "/Provincia")
        @ResponseBody
        public Iterable<Provincia> Provincias() {
                return servicioAeropuerto.dameProvincias();
        }


    //------------------- Ver Aeropuertos ----------------------------------------------------------

        @GetMapping(path = "/Aeropuerto")
        @ResponseBody
        public List<Aeropuerto> Aeropuertos() {
                return servicioAeropuerto.dameAeropuertos();
        }


    //------------------- Ver Aeropuerto por id -------------------------------------------------------------

    @GetMapping(path = "/Aeropuerto/{id}")
    public @ResponseBody
    Optional<Aeropuerto> Aeropuerto(@PathVariable long id) {
        return servicioAeropuerto.dameUnAeropuerto(id);
    }

    //------------------- Agregar Aeropuerto --------------------------------------------------------

        @RequestMapping(path = "/Aeropuerto", method=RequestMethod.POST, consumes = "application/json")
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public Aeropuerto AgregarNuevoAeropuerto(@RequestBody Aeropuerto aeropuerto) {
                return  servicioAeropuerto.agregarAeropuerto(aeropuerto);
        }

    //------------------- Borrar Aeropuerto --------------------------------------------------------

        @RequestMapping(path = "/Aeropuerto/{id}", method=RequestMethod.DELETE)
        public void BorrarAeropuerto(@PathVariable long id) {
             servicioAeropuerto.borrarAeropuerto(id);
        }


    //------------------- Modificar Aeropuerto --------------------------------------------------------

        @RequestMapping(value = "/Aeropuerto/{id}", method = RequestMethod.PUT)
        @ResponseStatus(HttpStatus.OK)
        public void Actualizar(@PathVariable long id, @RequestBody Aeropuerto aeropuerto) {
        servicioAeropuerto.actualizarAeropuerto(id,aeropuerto);
    }

}
