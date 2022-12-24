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
@Entity(name="artista")
public class Artista implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id_artista")
   private int id_artista;
   @Column(name="nombre_artista")
   private String nombre_artista;
   @Column(name="año_artista")
   private String año_artista;
   @ManyToOne
   @JoinColumn(name="id_nacionalidad")
   private Nacionalidad nacionalidad;

    public Artista(int id_artista, String nombre_artista, String año_artista, Nacionalidad nacionalidad) {
        this.id_artista = id_artista;
        this.nombre_artista = nombre_artista;
        this.año_artista = año_artista;
        this.nacionalidad = nacionalidad;
    }

    public Artista() {
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getAño_artista() {
        return año_artista;
    }

    public void setAño_artista(String año_artista) {
        this.año_artista = año_artista;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
   
   
}