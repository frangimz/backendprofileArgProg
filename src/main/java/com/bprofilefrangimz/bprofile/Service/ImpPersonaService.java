package com.bprofilefrangimz.bprofile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bprofilefrangimz.bprofile.Entity.Persona;
import com.bprofilefrangimz.bprofile.Interface.IPersonaService;
import com.bprofilefrangimz.bprofile.Repository.IPersonaRepository;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        // TODO Auto-generated method stub
        List<Persona> persona =ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        // TODO Auto-generated method stub
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        // TODO Auto-generated method stub
        ipersonaRepository.deleteById(id);
        
    }

    @Override
    public Persona findPersona(Long id) {
        // TODO Auto-generated method stub
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
