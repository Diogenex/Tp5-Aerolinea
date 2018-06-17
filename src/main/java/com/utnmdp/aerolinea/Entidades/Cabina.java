package com.utnmdp.aerolinea.Entidades;


import javax.persistence.*;

@Entity
public class Cabina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_cabina")
    private long id_cabina;


    @Column(name = "nombre_cabina")
    private String nombre_cabina;

    public String getNombre_cabina() {
        return nombre_cabina;
    }

    public void setNombre_cabina(String nombre_cabina) {
        this.nombre_cabina = nombre_cabina;
    }

    public long getId_cabina() {
        return id_cabina;
    }

    public void setId_cabina(long id_cabina) {
        this.id_cabina = id_cabina;
    }

    @Override
    public String toString() {
        return "Cabina{" +
                "id_cabina=" + id_cabina +
                ", nombre_cabina='" + nombre_cabina + '\'' +
                '}';
    }
}
