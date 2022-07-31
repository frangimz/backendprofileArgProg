package com.bprofilefrangimz.bprofile.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkill {
    @NotBlank
    private String nombre;
    @NotBlank
    private String img;
    @NotBlank
    private int porcentaje;
    //Constructores
    public dtoSkill() {
    }
    public dtoSkill(@NotBlank String nombre, @NotBlank String img, @NotBlank int porcentaje) {
        this.nombre = nombre;
        this.img = img;
        this.porcentaje = porcentaje;
    }
    //Getters and Setters
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
