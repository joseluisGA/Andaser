/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;

import Modelos.Subcategoria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author minit
 */
public class ServletContextAndaser implements ServletContextListener{
 private ServletContext context;

 private ArrayList<Categoria> aCat= new ArrayList();
 ArrayList<Subcategoria> aSubCat = new ArrayList();
 private Categoria cat;
 private Subcategoria subCat;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       
       
     
      
     try {
         
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
                     aux.setSubcategoria(aSubCat);  
                  }  
                }
               
               aAux.add(aux);
         }
         aCat = aAux;
         
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(ServletContextAndaser.class.getName()).log(Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
         Logger.getLogger(ServletContextAndaser.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
         Logger.getLogger(ServletContextAndaser.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(ServletContextAndaser.class.getName()).log(Level.SEVERE, null, ex);
     }
      
      
      
     
           
        
        context = sce.getServletContext();
            context.setAttribute("aCat", aCat);
            context.setAttribute("vista", "../views/galeria.jsp");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       context = sce.getServletContext();
    }
    
    
}
