package com.utnmdp.aerolinea.Entidades;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private long id_ruta;


    @ManyToOne
    @JoinColumn (name="id_origen",referencedColumnName="id_aeropuerto", nullable = false, unique=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Aeropuerto id_origen;

    @ManyToOne
    @JoinColumn (name="id_destino",referencedColumnName="id_aeropuerto", nullable = false, unique=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Aeropuerto id_destino;

    @Column(name = "distancia")
    private Integer distancia;

    public long getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(long id_ruta) {
        this.id_ruta = id_ruta;
    }

    public Aeropuerto getId_origen() {
        return id_origen;
    }

    public void setId_origen(Aeropuerto id_origen) {
        this.id_origen = id_origen;
    }

    public Aeropuerto getId_destino() {
        return id_destino;
    }

    public void setId_destino(Aeropuerto id_destino) {
        this.id_destino = id_destino;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

}
