/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import Modelos.Subcategoria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class AdminSubCategoria extends ActionSupport{
    private int id, idCat;
     private Conexion co;
      private List<Categoria>array_Cat = new ArrayList();
    private List<Subcategoria> aSubCat = new ArrayList();
    private String nombre, vista, service,nombreCat;

    public int getId() {
        return id;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

   

    public List<Subcategoria> getaSubCat() {
        return aSubCat;
    }

    public void setaSubCat(List<Subcategoria> aSubcat) {
        this.aSubCat = aSubcat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    
    @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        co = new Conexion("andaser", "root", "root");
          ServletContext context = ServletActionContext.getServletContext();
           if(service!=null){
         switch(service){
                case "insertar":
                    co.InsertarSubCategoria(nombreCat, nombre);
                    break;
                case "modificar":
                   co.ModificarSubCategoria(id, nombreCat, nombre);
                    break;
                case "borrar":
                   co.BorrarSubCategoria(id);
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
         ActionContext.getContext().getSession().put(("vista"), "views/adminSubcategoria.jsp");
           context.setAttribute("aCat", array_Cat);
            ActionContext.getContext().getSession().put("objeto", aSubCat);
         
         
         return SUCCESS;
    }
}
