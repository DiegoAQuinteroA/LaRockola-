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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="cancion")
public class Cancion implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id_cancion")
    private int id_cancion;
   @Column(name="nombre_cancion")
    private String nombre_cancion;
   @ManyToOne
   @JoinColumn(name="id_genero")
    private Genero genero;
   @ManyToOne
   @JoinColumn(name="id_album")
    private Album album;

    public Cancion(int id_cancion, String nombre_cancion, Genero genero, Album album) {
        this.id_cancion = id_cancion;
        this.nombre_cancion = nombre_cancion;
        this.genero = genero;
        this.album = album;
    }

    public Cancion() {
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    
}