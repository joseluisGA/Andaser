/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author minit
 */
public class Pedido {
    private int id,id_lista, precio, cantidad;
    private String REF, nombrePro;

    public Pedido(int id, int id_lista, int precio, int cantidad, String REF, String nombrePro) {
        this.id = id;
        this.id_lista = id_lista;
        this.precio = precio;
        this.cantidad = cantidad;
        this.REF = REF;
        this.nombrePro = nombrePro;
    }

    public Pedido(int precio, int cantidad, String REF, String nombrePro) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.REF = REF;
        this.nombrePro = nombrePro;
    }

    public Pedido() {
    }

    public Pedido(int id_lista, int precio, int cantidad, String REF, String nombrePro) {
        this.id_lista = id_lista;
        this.precio = precio;
        this.cantidad = cantidad;
        this.REF = REF;
        this.nombrePro = nombrePro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }
 
    
}