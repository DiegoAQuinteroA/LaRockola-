/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service.Implement;

import com.backend.larockola.Dao.CancionDao;
import com.backend.larockola.Models.Cancion;
import com.backend.larockola.Service.CancionService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
@Service
public class CancionServiceImpl implements CancionService {
    @Autowired
    private CancionDao cancionDao;
    
    @Override
    @Transactional(readOnly=false)
    public Cancion save (Cancion cancion) {
        return cancionDao.save(cancion);
    }
    
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        cancionDao.deleteById(id);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Cancion findById (Integer id) {
        return cancionDao.findById(id).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Cancion> findByAll () {
        return (List<Cancion>) cancionDao.findAll();
    }
}
