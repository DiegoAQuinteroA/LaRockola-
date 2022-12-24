/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;


import com.backend.larockola.Models.Cancion;
import java.util.List;


public interface CancionService {
    public Cancion save(Cancion cancion);
    public void delete(Integer id);
    public Cancion findById(Integer id);
    public List<Cancion>findByAll();
    
}
