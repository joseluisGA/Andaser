/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;


/**
 *
 * @author minit
 */
public class Inicio extends ActionSupport{
    private ArrayList<Categoria> aCat;
   

    public ArrayList<Categoria> getaCat() {
        return aCat;
    }

    public void setaCat(ArrayList<Categoria> aCat) {
        this.aCat = aCat;
    }

  
    
    @Override
    public String execute(){
      
     
     
     
        return SUCCESS;
    }
    
}
