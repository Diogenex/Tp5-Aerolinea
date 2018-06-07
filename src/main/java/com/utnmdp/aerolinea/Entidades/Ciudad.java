package com.utnmdp.aerolinea.Entidades;

import javax.persistence.*;

@Entity
public class Ciudad
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Integer id_ciudad;

    @Column(name = "nombre_ciudad", nullable = false, length = 150)
    private String nombre_ciudad;

    @Column(name = "codigo_iata", nullable = false, length = 3, unique = true)
    private String codigo_iata;

    public String getCodigo_iata() { return codigo_iata; }

    public void setCodigo_iata(String codigo_iata) { this.codigo_iata = codigo_iata; }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

}