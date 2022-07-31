package com.bprofilefrangimz.bprofile.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bprofilefrangimz.bprofile.Entity.Persona;
import com.bprofilefrangimz.bprofile.Interface.IPersonaService;
import com.bprofilefrangimz.bprofile.Repository.IPersonaRepository;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona =ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    public Optional <Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
        
}
