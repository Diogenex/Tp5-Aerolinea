package com.utnmdp.aerolinea.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Pais
{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_pais")
    private Integer id_pais;

    @Column(name = "nombre_pais", nullable = false , length = 100 , unique=true)
    private String nombre_pais;

//    @Column
//    @JsonBackReference
//    @JsonIgnore
//    private List<Ciudad> ciudad;

    @NotNull
    @Column(name = "codigo_iso" , length = 2, unique=true)
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


    @Override
    public String toString() {
        return "Pais{" +
                "id_pais=" + id_pais +
                ", nombre_pais='" + nombre_pais + '\'' +
                ", codigo_iso='" + codigo_iso + '\'' +
                '}';
    }
}
