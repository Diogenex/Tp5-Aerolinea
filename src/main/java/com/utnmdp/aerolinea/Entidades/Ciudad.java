package com.utnmdp.aerolinea.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;



@Table(name = "ciudad")
@Entity
public class Ciudad
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private long id_ciudad;

    @Column(name = "nombre_ciudad", nullable = false, length = 150)
    private String nombre_ciudad;

    @ManyToOne
    @JoinColumn (name="id_pais", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pais pais;

   /* @ManyToOne (fetch= FetchType.EAGER)
    @JoinColumn (name="id_provincia", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Provincia provincia;*/

    public long getId_ciudad() {
        return id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}