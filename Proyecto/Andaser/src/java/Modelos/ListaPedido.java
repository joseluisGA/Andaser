/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minit
 */
public class ListaPedido {
    private int id,idDir, precio_total;
    private String usuario, doc, fecha;
    private List<Pedido> array_ped = new ArrayList();
    private Direccion dir;
    public ListaPedido() {
    }

    public ListaPedido(int id, int idDir, int preci_total, String usuario, String doc, String fecha) {
        this.id = id;
        this.idDir = idDir;
        this.precio_total = preci_total;
        this.usuario = usuario;
        this.doc = doc;
        this.fecha = fecha;
    }

    public ListaPedido(int idDir, int preci_total, String usuario, String doc, String fecha) {
        this.idDir = idDir;
        this.precio_total = preci_total;
        this.usuario = usuario;
        this.doc = doc;
        this.fecha = fecha;
        
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int preci_total) {
        this.precio_total = preci_total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Pedido> getArray_ped() {
        return array_ped;
    }

    public void setArray_ped(List<Pedido> array_ped) {
        this.array_ped = array_ped;
    }
    
    
}
