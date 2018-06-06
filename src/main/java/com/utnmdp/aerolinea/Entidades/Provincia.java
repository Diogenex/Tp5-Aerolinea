package com.utnmdp.aerolinea.Entidades;

import javax.persistence.*;

@Entity
public class Provincia
{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_provincia")
        private Integer id_provincia;

        @Column(name = "nombre_provincia", nullable = false, length = 150)
        private String nombre_provincia;

        @Column(name = "codigo_iata", nullable = false, length = 3)
        private String codigo_iata;

        public String getNombre_provincia()
        {
            return nombre_provincia;
        }

        public void setNombre_provincia(String nombre_provincia)
        {
            this.nombre_provincia = nombre_provincia;
        }

        public String getCodigo_iata()
        {
            return codigo_iata;
        }

        public void setCodigo_iata(String codigo_iata)
        {
            this.codigo_iata = codigo_iata;
        }

}
