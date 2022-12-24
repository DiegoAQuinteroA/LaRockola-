/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.larockola.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Table
@Entity(name="album")
public class Album implements Serializable {
   
   @Id
   @Column(name="id_album")
    private int id_album;
   @Column(name="nombre_album")
    private String nombre_album;
   @Column(name="año_publicacion")
    private String año_publicacion;

    public Album(int id_album, String nombre_album, String año_publicacion) {
        this.id_album = id_album;
        this.nombre_album = nombre_album;
        this.año_publicacion = año_publicacion;
    }

    public Album() {
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(String año_publicacion) {
        this.año_publicacion = año_publicacion;
    }
    
}
