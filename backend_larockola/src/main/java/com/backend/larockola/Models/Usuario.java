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
@Entity(name="usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name="id_usuario")
    private String id_usuario;
    @Column(name="nombre_usu")
    private String nombre_usu;
    @Column(name="email_usu")
    private String email_usu;
    @Column(name="contraseña_usu")
    private String contraseña_usu;

    public Usuario(String id_usuario, String nombre_usu, String email_usu, String contraseña_usu) {
        this.id_usuario = id_usuario;
        this.nombre_usu = nombre_usu;
        this.email_usu = email_usu;
        this.contraseña_usu = contraseña_usu;
    }

    public Usuario() {
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    public String getContraseña_usu() {
        return contraseña_usu;
    }

    public void setContraseña_usu(String contraseña_usu) {
        this.contraseña_usu = contraseña_usu;
    }
    
    
    
}
