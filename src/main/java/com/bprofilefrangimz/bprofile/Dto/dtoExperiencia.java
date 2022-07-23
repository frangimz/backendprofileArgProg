package com.bprofilefrangimz.bprofile.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia{
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    //Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(@NotBlank String nombreE, @NotBlank String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    //Getters and Setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

}