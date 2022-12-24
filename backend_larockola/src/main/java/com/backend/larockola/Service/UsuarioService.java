/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;
import com.backend.larockola.Models.Usuario;
import java.util.List;


public interface UsuarioService {
    public Usuario save(Usuario usuario);
    public void delete(String id);
    public Usuario findById(String id);
    public List<Usuario>findByAll();
    
}
