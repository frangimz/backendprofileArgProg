package com.bprofilefrangimz.bprofile.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    //Constructores
    public dtoProyecto() {
    }
    public dtoProyecto(@NotBlank String nombre, @NotBlank String fecha, @NotBlank String descripcion,
            @NotBlank String img) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.img = img;
    }
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
}
