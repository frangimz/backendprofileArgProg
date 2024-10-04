package com.bprofilefrangimz.bprofile.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bprofilefrangimz.bprofile.Interface.IPersonaService;
import com.bprofilefrangimz.bprofile.Security.Controller.Mensaje;
import com.bprofilefrangimz.bprofile.Service.ImpPersonaService;

import java.util.List;

import com.bprofilefrangimz.bprofile.Dto.dtoPersona;
import com.bprofilefrangimz.bprofile.Entity.Persona;

@RestController
@RequestMapping("personas")
@CrossOrigin(origins = "https://frangimz.dev")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControler {
    @Autowired IPersonaService ipersonaService;
    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Persona creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        ipersonaService.deletePersona(id);
        return "Persona eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable int id,
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

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoPersona dtoperso){
        Persona persona = impPersonaService.getOne(id).get(); //ImpPersonaService.getOne(id).get();

        persona.setNombre(dtoperso.getNombre());
        persona.setDescripcion(dtoperso.getDescripcion());
        persona.setImg(dtoperso.getImg());
        persona.setTitulo(dtoperso.getTitulo());
        persona.setDescripcion(dtoperso.getDescripcion());

        impPersonaService.savePersona(persona);
        return new ResponseEntity<>(new Mensaje("Experiencia actualzada"), HttpStatus.OK);
    }

    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona(1);
    }
    
    @GetMapping("/test")
    public String test() {
    return "El backend está funcionando";
    }
}
