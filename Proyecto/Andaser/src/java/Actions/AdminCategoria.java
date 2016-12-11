/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import Modelos.Subcategoria;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ActionContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
/**
 *
 * @author minit
 */
public class AdminCategoria extends ActionSupport{
    private List<Categoria>array_Cat = new ArrayList();
    private List<Categoria> list_Menu = new ArrayList() ;
    private List<Subcategoria> aSubCat = new ArrayList();
    private String admin, vista, nombre;
    private int id;
    
    private String service;
    public List getArray_Cat() {
        return array_Cat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setArray_Cat(ArrayList array_Cat) {
        this.array_Cat = array_Cat;
    }



   

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    @Override
    public String execute(){
        
        try {
              ServletContext context = ServletActionContext.getServletContext();
            String resultado = SUCCESS;
            Conexion co = new Conexion("andaser", "root", "root");
            
            if(service!=null){
            switch(service){
                case "insertar":
                    co.InsertarCategoria(this.nombre);
                    break;
                case "modificar":
                    co.ModificarCategoria(id, nombre);
                    break;
                case "borrar":
                    co.BorrarCategoria(id);
                    break;
                   
            }
            }
            co.getAllCategoria();
         while (co.Obtener_Siguiente()){  
          
              array_Cat.add(new Categoria(co.Obtener_ID_Actual("ID"),co.Obtener_Actual("NOMBRE") ));  
             }
         Iterator<Categoria> it = array_Cat.iterator();
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
         array_Cat = aAux;
        ActionContext.getContext().getSession().put(("vista"), "views/adminCategoria.jsp");
           context.setAttribute("aCat", array_Cat);
            return resultado;
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        return SUCCESS;
    }
    
    
}
