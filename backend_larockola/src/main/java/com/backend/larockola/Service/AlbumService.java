/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service;

import com.backend.larockola.Models.Album;

import java.util.List;


public interface AlbumService {
    public Album save(Album album);
    public void delete(Integer id);
    public Album findById(Integer id);
    public List<Album>findByAll();
    
}
