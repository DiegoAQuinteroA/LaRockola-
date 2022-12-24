/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;

import com.backend.larockola.Models.Genero;
import com.backend.larockola.Service.GeneroService;
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
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @PostMapping(value="/")
    public ResponseEntity<Genero> agregar(@RequestBody Genero genero){
        Genero obj = generoService.save(genero);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Genero> eliminar(@PathVariable Integer id){
        Genero obj = generoService.findById(id);
        if(obj!=null)
            generoService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Genero> editar(@RequestBody Genero genero){
        Genero obj = generoService.findById(genero.getId_genero());
        if(obj!=null){
            obj.setNombre_genero(genero.getNombre_genero());
            generoService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Genero> consultarTodo(){
        return generoService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Genero consultarPorId(@PathVariable Integer id){
        return generoService.findById(id);
    }
}
