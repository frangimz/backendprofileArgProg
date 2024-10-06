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

import com.bprofilefrangimz.bprofile.Dto.dtoSkill;
import com.bprofilefrangimz.bprofile.Entity.Skill;
import com.bprofilefrangimz.bprofile.Security.Controller.Mensaje;
import com.bprofilefrangimz.bprofile.Service.SSkill;

@RestController
@RequestMapping("skill")
//@CrossOrigin(origins = "https://www.frangimz.dev")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill{
    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List <Skill> list = sSkill.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombre(dtoSkill.getNombre()))
            return new ResponseEntity<>(new Mensaje("Esa aptitud existe"),HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(dtoSkill.getNombre(),dtoSkill.getImg(),dtoSkill.getPorcentaje());
        sSkill.save(skill);

        return new ResponseEntity<>(new Mensaje("Aptitud agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoSkill dtoSkill){
        //validamos si existe el id
        if(!sSkill.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        //compara el nombre de Aptitud
        if(sSkill.existsByNombre(dtoSkill.getNombre()) && sSkill.getByNombre(dtoSkill.getNombre()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa Aptitud ya existe"),HttpStatus.BAD_REQUEST);
        //No puede estar vacio
            if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        Skill skill = sSkill.getOne(id).get();
        skill.setNombre(dtoSkill.getNombre());
        skill.setImg(dtoSkill.getImg());
        skill.setPorcentaje(dtoSkill.getPorcentaje());

        sSkill.save(skill);
        return new ResponseEntity<>(new Mensaje("Aptitud actualzada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>_delete (@PathVariable("id") int id){
        //validamos si existe el id
        if(!sSkill.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        sSkill.delete(id);
        
        return new ResponseEntity<>(new Mensaje("Aptitud eliminada"),HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity<Skill>(skill, HttpStatus.OK);
    }
}
