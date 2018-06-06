package com.utnmdp.aerolinea.Entidades;

import javax.persistence.*;

@Entity
public class Pais
{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_pais")
    private Integer id_pais;

    @Column(name = "nombre_pais", nullable = false , length = 150)
    private String nombre_pais;

    @Column(name = "codigo_iso" , nullable = false , length = 2)
    private String codigo_iso;

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getCodigo_iso() {
        return codigo_iso;
    }

    public void setCodigo_iso(String codigo_iso) {
        this.codigo_iso = codigo_iso;
    }
}
