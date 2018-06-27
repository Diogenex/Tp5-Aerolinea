package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Servicios.ServicioRuta;
import com.utnmdp.aerolinea.entidades.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorRuta {


        @Autowired
        private ServicioRuta servicioRuta;


        //------------------- Ver Rutas ----------------------------------------------------------

        @GetMapping(path = "/Rutas")
        @ResponseBody
        public Iterable<Ruta> Rutas() {
            return servicioRuta.dameRutas();
        }


        //------------------- Ver Ruta por id -------------------------------------------------------------

        @GetMapping(path = "/Rutas/{id}")
        public @ResponseBody
        Optional<Ruta> Ruta(@PathVariable long id) {
            return servicioRuta.dameUnaRuta(id);
        }

        //------------------- Ver Ruta por id -------------------------------------------------------------

        @GetMapping(path = "Aeropuerto/{id}/Rutas", produces = MediaType.APPLICATION_JSON_VALUE)
        public @ResponseBody
        List<Ruta> RutaporOrigen(@PathVariable long id) {
                return servicioRuta.verRutaOrigen(id);
        }

        //------------------- Agregar Ruta --------------------------------------------------------

        @RequestMapping(path = "/Rutas", method=RequestMethod.POST, consumes = "application/json")
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public Ruta AgregarNuevoAeropuerto(@RequestBody Ruta ruta) {
            return  servicioRuta.agregarRuta(ruta);
        }

        //------------------- Borrar Ruta --------------------------------------------------------

        @RequestMapping(path = "/Rutas/{id}", method=RequestMethod.DELETE)
        public void BorrarRuta(@PathVariable long id) { servicioRuta.borrarRuta(id);
        }


        //------------------- Modificar Ruta --------------------------------------------------------

        @RequestMapping(value = "/Rutas/{id}", method = RequestMethod.PUT)
        @ResponseStatus(HttpStatus.OK)
        public void Actualizar(@PathVariable long id, @RequestBody Ruta ruta) {
           servicioRuta.actualizarRuta(id, ruta);
        }

}
