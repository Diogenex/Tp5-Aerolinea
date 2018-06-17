package com.utnmdp.aerolinea.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PrecioxRutaxCabina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_precio")
    private Integer id_precio_cabina;

    @OneToOne
    @JoinColumn (name="id_ruta", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private Ruta id_ruta_fk;

    @OneToOne
    @JoinColumn (name="id_cabina", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private Cabina fk_cabina;


    @Column(name= "precio")
    private Integer precio;

    @Column(name= "vigencia_hasta")
    private Date vigencia_hasta;

    @Column(name= "vigencia_desde")
    private Date vigencia_desde;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Ruta getId_ruta_fk() {
        return id_ruta_fk;
    }

    public void setId_ruta_fk(Ruta id_ruta_fk) {
        this.id_ruta_fk = id_ruta_fk;
    }

    public Date getVigencia_hasta() {
        return vigencia_hasta;
    }

    public void setVigencia_hasta(Date vigencia_hasta) {
        this.vigencia_hasta = vigencia_hasta;
    }

    public Date getVigencia_desde() {
        return vigencia_desde;
    }

    public void setVigencia_desde(Date vigencia_desde) {
        this.vigencia_desde = vigencia_desde;
    }
}
