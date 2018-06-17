package com.utnmdp.aerolinea.Entidades;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;


@Table(name = "aeropuerto")
@Entity
public class Aeropuerto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aeropuerto")
    private long id_aeropuerto;

    @Column(name = "nombre_aeropuerto", nullable = false, length = 150)
    private String nombre_aeropuerto;

    @Column(name = "codigo_iata", nullable = false, length = 3,unique = true)
    private String codigo_iata;

    @ManyToOne
    @JoinColumn (name="id_ciudad", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ciudad ciudad;

   /* @ManyToOne (fetch= FetchType.EAGER)
    @JoinColumn (name="id_provincia", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Provincia provincia;*/

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getCodigo_iata() {
        return codigo_iata;
    }

    public void setCodigo_iata(String codigo_iata) {
        this.codigo_iata = codigo_iata;
    }

    public long getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(long id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    public String getNombre_aeropuerto() {
        return nombre_aeropuerto;
    }

    public void setNombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}