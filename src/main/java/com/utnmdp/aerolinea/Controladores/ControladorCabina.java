package com.utnmdp.aerolinea.Controladores;

import com.utnmdp.aerolinea.Servicios.ServicioCabinas;
import com.utnmdp.aerolinea.entidades.Cabina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ControladorCabina {

    @Autowired
    private ServicioCabinas servicioCabinas;

    @GetMapping(path = "/Cabina")
    public  ResponseEntity <Iterable<Cabina>> Cabinas() {
      return new ResponseEntity<>(servicioCabinas.dameCabinas(), HttpStatus.OK);
    }

    @PostMapping(path = "/Cabina")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Cabina agregarCabina(@RequestBody Cabina cabina){
        return  servicioCabinas.agregarCabina(cabina);
    }

    @GetMapping(value = "Cabina/{id}")
    public  ResponseEntity<Optional<Cabina>> Cabina(@PathVariable long id) {
        boolean respuesta = servicioCabinas.verExistencia(id);
        if (respuesta == true) {
            return new ResponseEntity<>(servicioCabinas.unaCabina(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @RequestMapping(value = "Cabina/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> borrarCabina(@PathVariable long id) {
        servicioCabinas.eliminarCabina(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
