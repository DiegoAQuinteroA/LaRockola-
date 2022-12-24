/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;

import com.backend.larockola.Models.Artista;
import java.util.List;


public interface ArtistaService {
    public Artista save(Artista artista);
    public void delete(Integer id);
    public Artista findById(Integer id);
    public List<Artista>findByAll();
    
}
