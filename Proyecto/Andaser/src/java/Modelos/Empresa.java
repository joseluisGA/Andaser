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
public class Empresa {
    private String nif, nombre;
    private Usuario user;
    private Direccion dir;

    public Empresa(String nif, String nombre, Direccion dir) {
        this.nif = nif;
        this.nombre = nombre;
        this.dir = dir;
    }

    public Empresa(String nif, String nombre, Usuario user, Direccion dir) {
        this.nif = nif;
        this.nombre = nombre;
        this.user = user;
        this.dir = dir;
    }

    public Empresa(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }
    
    
}
