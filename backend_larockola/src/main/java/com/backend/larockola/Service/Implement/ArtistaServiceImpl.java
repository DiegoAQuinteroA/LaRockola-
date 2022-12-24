/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service.Implement;
import com.backend.larockola.Dao.ArtistaDao;
import com.backend.larockola.Models.Artista;
import com.backend.larockola.Service.ArtistaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
@Service
public class ArtistaServiceImpl implements ArtistaService {
    @Autowired
    private ArtistaDao artistaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Artista save (Artista artista) {
        return artistaDao.save(artista);
    }
    
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        artistaDao.deleteById(id);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Artista findById (Integer id) {
        return artistaDao.findById(id).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Artista> findByAll () {
        return (List<Artista>) artistaDao.findAll();
    }
}
