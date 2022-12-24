/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;

import com.backend.larockola.Models.Cancion;
import com.backend.larockola.Service.CancionService;
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
@RequestMapping("/cancion")
public class CancionController {
    @Autowired
    private CancionService cancionService;
    
    @PostMapping(value="/")
    public ResponseEntity<Cancion> agregar(@RequestBody Cancion cancion){
        Cancion obj = cancionService.save(cancion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Cancion> eliminar(@PathVariable Integer id){
        Cancion obj = cancionService.findById(id);
        if(obj!=null)
            cancionService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Cancion> editar(@RequestBody Cancion cancion){
        Cancion obj = cancionService.findById(cancion.getId_cancion());
        if(obj!=null){
            obj.setNombre_cancion(cancion.getNombre_cancion());
            cancionService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Cancion> consultarTodo(){
        return cancionService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Cancion consultarPorId(@PathVariable Integer id){
        return cancionService.findById(id);
    }
}
