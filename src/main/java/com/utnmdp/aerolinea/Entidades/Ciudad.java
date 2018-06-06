package com.utnmdp.aerolinea.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ciudad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ciudad;

    private String nombre_ciudad;



    public String getNombre_ciudad() {
        return nombre_ciudad;
    }


    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

}