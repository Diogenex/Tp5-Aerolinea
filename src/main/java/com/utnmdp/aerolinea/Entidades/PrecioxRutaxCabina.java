package com.utnmdp.aerolinea.Entidades;

import javax.persistence.*;

@Entity
public class PrecioCabina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_precio_cabina")
    private String id_precio_cabina;


    @Column(name= "precio")
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
