package com.bprofilefrangimz.bprofile.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;

    //constructores
    public Educacion() {
    }
    public Educacion(String nombreEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }
    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreEd() {
        return nombreEd;
    }
    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }
    public String getDescripcionEd() {
        return descripcionEd;
    }
    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
}
