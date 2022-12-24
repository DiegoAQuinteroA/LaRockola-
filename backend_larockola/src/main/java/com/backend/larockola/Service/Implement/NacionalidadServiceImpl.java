/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service.Implement;
import com.backend.larockola.Dao.NacionalidadDao;
import com.backend.larockola.Models.Nacionalidad;
import com.backend.larockola.Service.NacionalidadService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
@Service
public class NacionalidadServiceImpl implements NacionalidadService {
    @Autowired
    private NacionalidadDao nacionalidadDao;
    
    @Override
    @Transactional(readOnly=false)
    public Nacionalidad save (Nacionalidad nacionalidad) {
        return nacionalidadDao.save(nacionalidad);
    }
    
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        nacionalidadDao.deleteById(id);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Nacionalidad findById (Integer id) {
        return nacionalidadDao.findById(id).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Nacionalidad> findByAll () {
        return (List<Nacionalidad>) nacionalidadDao.findAll();
    }
}
