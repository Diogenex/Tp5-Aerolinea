package com.utnmdp.aerolinea.Entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "provincia")
@Entity
public class Provincia
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_provincia")
        private long id_provincia;

        /*@OneToOne(fetch= FetchType.EAGER)
        @JoinColumn (name="id_pais", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonBackReference
        private Pais pais;*/

        @NotNull
        @Size(max = 150)
        @Column(name = "nombre_provincia")
        private String nombre_provincia;


        public void setId_provincia(long id_provincia) {
        this.id_provincia = id_provincia;
    }

//        public void setPais(Pais pais) {
//        this.pais = pais;
//    }


        public String getNombre_provincia()

        {
            return nombre_provincia;
        }


        public void setNombre_provincia(String nombre_provincia)
        {
            this.nombre_provincia = nombre_provincia;
        }

        public long getId_provincia()
        {
                return id_provincia;
        }

//        public Pais getPais()
//        {
//                return pais;
//        }


}
