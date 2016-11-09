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

public class Subcategoria {
    private int id_subCat;
    private int id_categoria;
    private String nombreSubCat;
   
    
    public Subcategoria(){
        
    }

    public Subcategoria(int id_subCat, int id_categoria, String nombreSubCat) {
        this.id_subCat = id_subCat;
        this.id_categoria = id_categoria;
        this.nombreSubCat = nombreSubCat;
    }

    public int getId_subCat() {
        return id_subCat;
    }

    public void setId_subCat(int id_subCat) {
        this.id_subCat = id_subCat;
    }

    public String getNombreSubCat() {
        return nombreSubCat;
    }

    public void setNombreSubCat(String nombreSubCat) {
        this.nombreSubCat = nombreSubCat;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
}
   
   
