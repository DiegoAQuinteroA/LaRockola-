/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;
import com.backend.larockola.Models.Artista;
import com.backend.larockola.Service.ArtistaService;
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
@RequestMapping("/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;
    
    @PostMapping(value="/")
    public ResponseEntity<Artista> agregar(@RequestBody Artista artista){
        Artista obj = artistaService.save(artista);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Artista> eliminar(@PathVariable Integer id){
        Artista obj = artistaService.findById(id);
        if(obj!=null)
            artistaService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Artista> editar(@RequestBody Artista artista){
        Artista obj = artistaService.findById(artista.getId_artista());
        if(obj!=null){
            obj.setNombre_artista(artista.getNombre_artista());
            obj.setAño_artista(artista.getAño_artista());
            artistaService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Artista> consultarTodo(){
        return artistaService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Artista consultarPorId(@PathVariable Integer id){
        return artistaService.findById(id);
    }
}
