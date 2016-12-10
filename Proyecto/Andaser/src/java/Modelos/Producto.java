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

public class Producto {
    
    private String REF;
    private String nombre;
    private String descripcion;
    private int id_categoria;
    private int id_subcategoria;
    private int precio1;
    private int precio2;
   
    private String ficha;
    private String imagen;

    public Producto(String REF, String nombre, String descripcion, int id_categoria, int id_subcategoria, int precio1, int precio2,  String ficha, String imagen) {
        this.REF = REF;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_categoria = id_categoria;
        this.id_subcategoria = id_subcategoria;
        this.precio1 = precio1;
        this.precio2 = precio2;
       
        this.ficha = ficha;
        this.imagen = imagen;
    }
    public Producto(){
        
    }
    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(int id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public int getPrecio1() {
        return precio1;
    }

    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }

    

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
   

}