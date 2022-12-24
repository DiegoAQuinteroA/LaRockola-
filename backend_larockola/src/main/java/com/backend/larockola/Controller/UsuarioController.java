/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Controller;

import com.backend.larockola.Models.Usuario;
import com.backend.larockola.Service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping(value="/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable String id){
        Usuario obj = usuarioService.findById(id);
        if(obj!=null)
            usuarioService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.findById(usuario.getId_usuario());
        if(obj!=null){
            obj.setNombre_usu(usuario.getNombre_usu());
            obj.setEmail_usu(usuario.getEmail_usu());
            obj.setContraseña_usu(usuario.getContraseña_usu());
            usuarioService.save(obj);
        }
        else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @GetMapping("/list")
    public List<Usuario> consultarTodo(){
        return usuarioService.findByAll();
    }
    
    @GetMapping("/list/{id}")
    public Usuario consultarPorId(@PathVariable String id){
        return usuarioService.findById(id);
    }
}
