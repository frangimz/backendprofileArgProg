package com.bprofilefrangimz.bprofile.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bprofilefrangimz.bprofile.Entity.Skill;

@Repository
public interface RSkill extends JpaRepository<Skill,Integer>{
    public Optional<Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
