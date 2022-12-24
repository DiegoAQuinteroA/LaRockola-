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
@Entity(name="nacionalidad")
public class Nacionalidad implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id_nacionalidad")
    private int id_nacionalidad;
   @Column(name="nombre_nacionalidad")
    private String nombre_nacionalidad;

    public Nacionalidad(int id_nacionalidad, String nombre_nacionalidad) {
        this.id_nacionalidad = id_nacionalidad;
        this.nombre_nacionalidad = nombre_nacionalidad;
    }

    public Nacionalidad() {
    }

    public int getId_nacionalidad() {
        return id_nacionalidad;
    }

    public void setId_nacionalidad(int id_nacionalidad) {
        this.id_nacionalidad = id_nacionalidad;
    }

    public String getNombre_nacionalidad() {
        return nombre_nacionalidad;
    }

    public void setNombre_nacionalidad(String nombre_nacionalidad) {
        this.nombre_nacionalidad = nombre_nacionalidad;
    }
    
    
    
}
