/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Service.Implement;
import com.backend.larockola.Dao.AlbumDao;
import com.backend.larockola.Models.Album;
import com.backend.larockola.Service.AlbumService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    
    @Override
    @Transactional(readOnly=false)
    public Album save (Album album) {
        return albumDao.save(album);
    }
    
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        albumDao.deleteById(id);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Album findById (Integer id) {
        return albumDao.findById(id).orElse(null);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Album> findByAll () {
        return (List<Album>) albumDao.findAll();
    }
}
