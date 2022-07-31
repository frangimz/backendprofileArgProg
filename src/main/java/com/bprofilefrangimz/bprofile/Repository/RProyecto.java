package com.bprofilefrangimz.bprofile.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bprofilefrangimz.bprofile.Entity.Proyecto;

@Repository
public interface RProyecto extends JpaRepository<Proyecto,Integer> {
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
