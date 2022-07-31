package com.bprofilefrangimz.bprofile.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String img;
    private int porcentaje;
    //Constructores
    public Skill(String nombre, String img, int porcentaje) {
        this.nombre = nombre;
        this.img = img;
        this.porcentaje = porcentaje;
    }
    public Skill() {
    }
    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
