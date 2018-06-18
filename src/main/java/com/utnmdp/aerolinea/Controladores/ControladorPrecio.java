package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Entidades.PrecioxRutaxCabina;
import com.utnmdp.aerolinea.Servicios.ServicioPrecioxRutaxCabina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ControladorPrecio {
    @Autowired
    private ServicioPrecioxRutaxCabina servicioPrecioxRutaxCabina;


    //------------------- Ver Precios ----------------------------------------------------------

    @GetMapping(path = "/Precios")
    @ResponseBody
    public Iterable<PrecioxRutaxCabina> Precios() {
        return servicioPrecioxRutaxCabina.damePrecios();
    }


    //------------------- Ver Precio por id -------------------------------------------------------------

    @GetMapping(path = "/Precios/{id}")
    public @ResponseBody
    Optional<PrecioxRutaxCabina> Precio(@PathVariable long id) {
        return servicioPrecioxRutaxCabina.dameUnPrecio(id);
    }

    //------------------- Agregar Precio --------------------------------------------------------

    @RequestMapping(path = "/Precios", method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PrecioxRutaxCabina AgregarNuevoPrecio(@RequestBody PrecioxRutaxCabina precio) {
        return  servicioPrecioxRutaxCabina.agregarPrecio(precio);
    }

    //------------------- Borrar Precio --------------------------------------------------------

    @RequestMapping(path = "/Precios/{id}", method=RequestMethod.DELETE)
    public void BorrarPrecio(@PathVariable long id) { servicioPrecioxRutaxCabina.borrarPrecio(id);
    }


    //------------------- Modificar Precio --------------------------------------------------------

    @RequestMapping(value = "/Precios/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void Actualizar(@PathVariable long id, @RequestBody PrecioxRutaxCabina precio) {
        servicioPrecioxRutaxCabina.actualizarPrecio(id, precio);
    }

}
