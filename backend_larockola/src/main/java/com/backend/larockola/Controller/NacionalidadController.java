/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;
import com.backend.larockola.Models.Nacionalidad;
import com.backend.larockola.Service.NacionalidadService;
import java.util.List;

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

@RestController
@CrossOrigin("*")
@RequestMapping("/nacionalidad")
public class NacionalidadController {
    @Autowired
    private NacionalidadService nacionalidadService;
    
    @PostMapping(value="/")
    public ResponseEntity<Nacionalidad> agregar(@RequestBody Nacionalidad nacionalidad){
        Nacionalidad obj = nacionalidadService.save(nacionalidad);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Nacionalidad> eliminar(@PathVariable Integer id){
        Nacionalidad obj = nacionalidadService.findById(id);
        if(obj!=null)
            nacionalidadService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Nacionalidad> editar(@RequestBody Nacionalidad nacionalidad){
        Nacionalidad obj = nacionalidadService.findById(nacionalidad.getId_nacionalidad());
        if(obj!=null){
            obj.setNombre_nacionalidad(nacionalidad.getNombre_nacionalidad());
            nacionalidadService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Nacionalidad> consultarTodo(){
        return nacionalidadService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Nacionalidad consultarPorId(@PathVariable Integer id){
        return nacionalidadService.findById(id);
    }
}
