/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;



/**
 *
 * @author minit
 */

public class Categoria {
    
    private int id;
    private String nombre;
    private ArrayList<Subcategoria> subcategoria;
    

    public Categoria(){
        
    }
    
    public Categoria(int id, String nombre, ArrayList<Subcategoria> subcategoria) {
        this.id = id;
        this.nombre = nombre;
        this.subcategoria = subcategoria;
    }
    
      public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
      
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Subcategoria> getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(ArrayList<Subcategoria> subcategoria) {
        this.subcategoria = subcategoria;
    }
  
   
    
    
    
}
