package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Servicios.ServicioAeropuerto;
import com.utnmdp.aerolinea.entidades.Aeropuerto;
import com.utnmdp.aerolinea.entidades.Ciudad;
import com.utnmdp.aerolinea.entidades.Pais;
import com.utnmdp.aerolinea.entidades.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorAeropuerto {

        @Autowired
        private ServicioAeropuerto servicioAeropuerto;

        //------------------- Ver Ciudades ------------------------------------------------------------------

        @ResponseStatus(HttpStatus.OK)
        @GetMapping(path = "/Ciudad" , produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public Iterable<Ciudad> Ciudades()
        {
                return servicioAeropuerto.dameCiudades();
        }



        //------------------- Ver Ciudad por id -------------------------------------------------------------

        @GetMapping(path = "/Ciudad/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public Optional<Ciudad> Ciudades(@PathVariable long id)
        {
            return servicioAeropuerto.dameUnaCiudad(id);
        }

        //------------------------ Ver Ciudad por nombre  ----------------------------------------------------------------

        @GetMapping(path = "/Ciudad/", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        public @ResponseBody
        Ciudad CiudadPorNOmbre(@RequestParam(value="nombre") String nombre )
        {
            return servicioAeropuerto.dameCiudadPorNombre(nombre);
        }


        //------------------------ Ver Paises ----------------------------------------------------------------

        @GetMapping(path = "/Pais", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        public @ResponseBody
        Iterable<Pais> Paises()
        {
                return servicioAeropuerto.damePaises();
        }



        //------------------------ Ver País por Código ISO  ----------------------------------------------------------------

        @GetMapping(path = "/Pais/{iso}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        public @ResponseBody
        Optional<Pais> PaisPorIso(@PathVariable String iso )
        {
                return servicioAeropuerto.damePaisPorIso(iso);
        }


        //------------------- Ver Provincias --------------------------------------------------------

        @GetMapping(path = "/Provincia", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        @ResponseBody
        public Iterable<Provincia> Provincias()
        {
                return servicioAeropuerto.dameProvincias();
        }



        //------------------- Ver Aeropuertos ----------------------------------------------------------

        @GetMapping(path = "/Aeropuerto", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        @ResponseBody
        public List<Aeropuerto> Aeropuertos()
        {
                return servicioAeropuerto.dameAeropuertos();
        }



        //------------------- Ver Aeropuerto por id -------------------------------------------------------------

        @GetMapping(path = "/Aeropuerto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        @ResponseBody
        public
        Optional<Aeropuerto> Aeropuerto(@PathVariable long id)
        {
        return servicioAeropuerto.dameUnAeropuerto(id);
        }


        //------------------- Agregar Aeropuerto --------------------------------------------------------

        @RequestMapping(path = "/Aeropuerto", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
        @ResponseStatus(value = HttpStatus.CREATED)
        @ResponseBody
        public Aeropuerto AgregarNuevoAeropuerto(@RequestBody Aeropuerto aeropuerto)
        {
                long tieneId = aeropuerto.getCiudad().getId_ciudad();
                if(tieneId != 0){
                    return  servicioAeropuerto.agregarAeropuerto(aeropuerto);
                }
                else{
                    aeropuerto.setCiudad(servicioAeropuerto.dameCiudadPorNombre(aeropuerto.getCiudad().getNombre_ciudad()));
                    return  servicioAeropuerto.agregarAeropuerto(aeropuerto);
                }

        }


        //------------------- Borrar Aeropuerto --------------------------------------------------------

        @RequestMapping(path = "/Aeropuerto/{id}", method=RequestMethod.DELETE)
        public void BorrarAeropuerto(@PathVariable long id)
        {
             servicioAeropuerto.borrarAeropuerto(id);
        }



        //------------------- Modificar Aeropuerto --------------------------------------------------------

        @RequestMapping(value = "/Aeropuerto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

        public void Actualizar(@PathVariable long id, @RequestBody Aeropuerto aeropuerto)
        {
        servicioAeropuerto.actualizarAeropuerto(id,aeropuerto);
        }

}
