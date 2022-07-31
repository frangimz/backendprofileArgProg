package com.bprofilefrangimz.bprofile.Interface;

import com.bprofilefrangimz.bprofile.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();

    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);

    //Eliminar un objeto buscandolo por id
    public void deletePersona(int id);

    //Buscar una persona por id
    public Persona findPersona(int id);
}
