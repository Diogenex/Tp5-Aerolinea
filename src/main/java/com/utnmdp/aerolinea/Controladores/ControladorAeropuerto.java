package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Entidades.Ciudad;
import com.utnmdp.aerolinea.Entidades.Pais;
import com.utnmdp.aerolinea.Entidades.Provincia;
import com.utnmdp.aerolinea.Repositorios.CiudadRepositorio;
import com.utnmdp.aerolinea.Repositorios.PaisRepositorio;
import com.utnmdp.aerolinea.Repositorios.ProvinciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EndPointControlador
{
        @Autowired
        private CiudadRepositorio ciudadRepositorio;

        @GetMapping(path = "/Ciudad/todos")
        public @ResponseBody  Iterable<Ciudad> dameTodas ()
        {
        return ciudadRepositorio.findAll();
        }

        @Autowired
        private PaisRepositorio paisRepositorio;

        @GetMapping(path = "/Pais/todos")
        public @ResponseBody  Iterable<Pais> Paises ()
        {
            return paisRepositorio.findAll();
        }

        @Autowired
        private ProvinciaRepositorio provinciaRepositorio;

        @GetMapping(path = "/Provincia/todos")
        public @ResponseBody  Iterable<Provincia> Provincias ()
        {
            return provinciaRepositorio.findAll();
        }



        @GetMapping(path = "/agregar")
        public  @ResponseBody String AgregarNuevaCiudad(@RequestParam String nombre)
        {
            Ciudad nCiudad = new Ciudad();
            nCiudad.setNombre_ciudad(nombre);
            ciudadRepositorio.save(nCiudad);
            return "Guardado!";

        }


}
