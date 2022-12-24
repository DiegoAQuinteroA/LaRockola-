/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;
import com.backend.larockola.Models.Album;
import com.backend.larockola.Service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    
    @PostMapping(value="/")
    public ResponseEntity<Album> agregar(@RequestBody Album album){
        Album obj = albumService.save(album);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Album> eliminar(@PathVariable Integer id){
        Album obj = albumService.findById(id);
        if(obj!=null)
            albumService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Album> editar(@RequestBody Album album){
        Album obj = albumService.findById(album.getId_album());
        if(obj!=null){
            obj.setNombre_album(album.getNombre_album());
            obj.setAño_publicacion(album.getAño_publicacion());
            albumService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Album> consultarTodo(){
        return albumService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Album consultarPorId(@PathVariable Integer id){
        return albumService.findById(id);
    }
}
