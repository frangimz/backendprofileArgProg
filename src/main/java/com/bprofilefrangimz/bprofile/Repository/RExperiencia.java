package com.bprofilefrangimz.bprofile.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bprofilefrangimz.bprofile.Entity.Experiencia;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Integer>{
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
