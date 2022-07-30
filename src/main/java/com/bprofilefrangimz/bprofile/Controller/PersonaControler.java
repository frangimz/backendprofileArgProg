package com.bprofilefrangimz.bprofile.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bprofilefrangimz.bprofile.Interface.IPersonaService;
import java.util.List;
import com.bprofilefrangimz.bprofile.Entity.Persona;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://hosting-myprofile.web.app")
public class PersonaControler {
    @Autowired IPersonaService ipersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Persona creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Persona eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevoDescripcion){
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setTitulo(nuevoTitulo);
        persona.setDescripcion(nuevoDescripcion);

        ipersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
