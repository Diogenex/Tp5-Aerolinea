package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Entidades.Ciudad;
import com.utnmdp.aerolinea.Repositorios.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EndPointControlador
{
        @Autowired
        private CiudadRepositorio ciudadRepositorio;

        @GetMapping(path = "/agregar")
        public  @ResponseBody String AgregarNuevaCiudad(@RequestParam String nombre)
        {
            Ciudad nCiudad = new Ciudad();
            nCiudad.setNombre_ciudad(nombre);
            ciudadRepositorio.save(nCiudad);
            return "Guardado!";

        }

        @GetMapping(path = "/todos")
        public @ResponseBody  Iterable<Ciudad> dameTodas ()
        {
            return ciudadRepositorio.findAll();
        }
}
