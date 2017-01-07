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
public class Cliente {
    private String dni, nombre, ape1, ape2; 
    private Usuario user;
    private Direccion dir;

    public Cliente(String dni, String nombre, String ape1, String ape2) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public Cliente(String dni, String nombre, String ape1, String ape2, Usuario user, Direccion dir) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.user = user;
        this.dir = dir;
    }

    public Cliente() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
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
