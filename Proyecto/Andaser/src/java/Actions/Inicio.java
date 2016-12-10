/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import Modelos.Subcategoria;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;


/**
 *
 * @author minit
 */
public class Inicio extends ActionSupport{
   private ServletContext context;

 private ArrayList<Categoria> aCat= new ArrayList();
 private List<Subcategoria> aSubCat = new ArrayList();
 private Categoria cat;
 private Subcategoria subCat;

    public ArrayList<Categoria> getaCat() {
        return aCat;
    }

    public void setaCat(ArrayList<Categoria> aCat) {
        this.aCat = aCat;
    }

    public List<Subcategoria> getaSubCat() {
        return aSubCat;
    }

    public void setaSubCat(ArrayList<Subcategoria> aSubCat) {
        this.aSubCat = aSubCat;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public Subcategoria getSubCat() {
        return subCat;
    }

    public void setSubCat(Subcategoria subCat) {
        this.subCat = subCat;
    }
 
 
  
    
   
   @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    ServletContext context = ServletActionContext.getServletContext();
            Conexion co = new Conexion("andaser", "root", "root");
              co.getAllCategoria();
         while (co.Obtener_Siguiente()){  
          
              aCat.add(new Categoria(co.Obtener_ID_Actual("ID"),co.Obtener_Actual("NOMBRE") ));  
             }
         Iterator<Categoria> it = aCat.iterator();
         Categoria aux;
         ArrayList<Categoria> aAux = new ArrayList();
         while(it.hasNext()){
             aux = it.next();
           co.getSubCategoria(aux.getId());
                while(co.Obtener_Siguiente()){
                  if(co.Obtener_Actual("ID")!=null){
                      aSubCat.add(new Subcategoria(co.Obtener_ID_Actual("ID"),aux.getId(), co.Obtener_Actual("NOMBRE")));
                     aux.setSubcategoria((ArrayList<Subcategoria>) aSubCat);  
                  }  
                }
               
               aAux.add(aux);
         }
         aCat = aAux;
          
            context.setAttribute("aCat", aCat);
            context.setAttribute("vista", "views/galeria.jsp");
        
     
     
     
        return SUCCESS;
    }
    
}
