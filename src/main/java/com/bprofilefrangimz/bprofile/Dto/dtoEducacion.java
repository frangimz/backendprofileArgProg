package com.bprofilefrangimz.bprofile.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;

    //Constructores
    public dtoEducacion() {
    }
    public dtoEducacion(@NotBlank String nombreEd, @NotBlank String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }

    //Getters and Setters
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
