package com.bprofilefrangimz.bprofile.Security.Service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bprofilefrangimz.bprofile.Security.Entity.Rol;
import com.bprofilefrangimz.bprofile.Security.Enums.RolNombre;
import com.bprofilefrangimz.bprofile.Security.Repository.iRolRepository;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
