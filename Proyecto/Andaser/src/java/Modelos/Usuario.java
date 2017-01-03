/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author minit
 */
public class Usuario {
    private String nombre, password, email;
    private int rol, estado;

    public Usuario(String nombre, String password, String email, int rol) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }
    public Usuario(String nombre, String password, String email, int rol, int estado) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
}
