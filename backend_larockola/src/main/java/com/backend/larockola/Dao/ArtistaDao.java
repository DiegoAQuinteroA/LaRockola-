/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Dao;

import com.backend.larockola.Models.Artista;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Diego
 */
public interface ArtistaDao extends CrudRepository<Artista, Integer>  {
    
}

