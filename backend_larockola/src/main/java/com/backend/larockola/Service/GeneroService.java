/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;

import com.backend.larockola.Models.Genero;
import java.util.List;


public interface GeneroService {
    public Genero save(Genero genero);
    public void delete(Integer id);
    public Genero findById(Integer id);
    public List<Genero>findByAll();
    
}
