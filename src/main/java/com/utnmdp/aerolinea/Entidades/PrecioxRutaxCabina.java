package com.utnmdp.aerolinea.Entidades;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PrecioxRutaxCabina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_precio")
    private long id_precio_cabina;

    @ManyToOne
    @JoinColumn (name="id_ruta", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ruta id_ruta_fk;

    @ManyToOne
    @JoinColumn (name="id_cabina", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cabina fk_cabina;


    @Column(name= "precio")
    private Integer precio;

    @Column(name= "vigencia_hasta")
    private Date vigencia_hasta;

    @Column(name= "vigencia_desde")
    private Date vigencia_desde;

    public long getId_precio_cabina() {
        return id_precio_cabina;
    }

    public void setId_precio_cabina(long id_precio_cabina) {
        this.id_precio_cabina = id_precio_cabina;
    }

    public Cabina getFk_cabina() {
        return fk_cabina;
    }

    public void setFk_cabina(Cabina fk_cabina) {
        this.fk_cabina = fk_cabina;
    }

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
