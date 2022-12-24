/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service.Implement;

import com.backend.larockola.Dao.GeneroDao;
import com.backend.larockola.Models.Genero;
import com.backend.larockola.Service.GeneroService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroDao generoDao;
    
    @Override
    @Transactional(readOnly=false)
    public Genero save (Genero genero) {
        return generoDao.save(genero);
    }
    
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        generoDao.deleteById(id);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Genero findById (Integer id) {
        return generoDao.findById(id).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Genero> findByAll () {
        return (List<Genero>) generoDao.findAll();
    }
}
