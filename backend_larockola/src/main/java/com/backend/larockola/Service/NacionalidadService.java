/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;

import com.backend.larockola.Models.Nacionalidad;
import java.util.List;


public interface NacionalidadService {
    public Nacionalidad save(Nacionalidad nacionalidad);
    public void delete(Integer id);
    public Nacionalidad findById(Integer id);
    public List<Nacionalidad>findByAll();
    
}
