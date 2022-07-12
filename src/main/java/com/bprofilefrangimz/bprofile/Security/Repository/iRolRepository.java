package com.bprofilefrangimz.bprofile.Security.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bprofilefrangimz.bprofile.Security.Entity.Rol;
import com.bprofilefrangimz.bprofile.Security.Enums.RolNombre;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional <Rol> findByRolNombre(RolNombre rolNombre);    
}
