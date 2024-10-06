package com.bprofilefrangimz.bprofile.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bprofilefrangimz.bprofile.Dto.dtoProyecto;
import com.bprofilefrangimz.bprofile.Entity.Proyecto;
import com.bprofilefrangimz.bprofile.Security.Controller.Mensaje;
import com.bprofilefrangimz.bprofile.Service.SProyecto;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "https://www.frangimz.dev")
//@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List <Proyecto> list = sProyecto.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoProyecto){
        if(StringUtils.isBlank(dtoProyecto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombre(dtoProyecto.getNombre()))
            return new ResponseEntity<>(new Mensaje("Esa proyecto existe"),HttpStatus.BAD_REQUEST);
        Proyecto Proyecto = new Proyecto(dtoProyecto.getNombre(),dtoProyecto.getFecha(),dtoProyecto.getDescripcion(),dtoProyecto.getImg());
        sProyecto.save(Proyecto);

        return new ResponseEntity<>(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoProyecto){
        //validamos si existe el id
        if(!sProyecto.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        //compara el nombre de Proyecto
        if(sProyecto.existsByNombre(dtoProyecto.getNombre()) && sProyecto.getByNombre(dtoProyecto.getNombre()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa proyecto ya existe"),HttpStatus.BAD_REQUEST);
        //No puede estar vacio
            if(StringUtils.isBlank(dtoProyecto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        Proyecto Proyecto = sProyecto.getOne(id).get();
        Proyecto.setNombre(dtoProyecto.getNombre());
        Proyecto.setImg(dtoProyecto.getImg());
        Proyecto.setDescripcion(dtoProyecto.getDescripcion());
        Proyecto.setFecha(dtoProyecto.getFecha());

        sProyecto.save(Proyecto);
        return new ResponseEntity<>(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>_delete (@PathVariable("id") int id){
        //validamos si existe el id
        if(!sProyecto.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        sProyecto.delete(id);
        
        return new ResponseEntity<>(new Mensaje("Proyecto eliminada"),HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto Proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity<Proyecto>(Proyecto, HttpStatus.OK);
    }
}
