/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import com.opensymphony.xwork2.ActionSupport;

import Modelos.CategoriaDao;
import com.opensymphony.xwork2.ActionContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author minit
 */
public class AdminCategoria extends ActionSupport{
    private ArrayList array_Cat;
    private List<Categoria> list_Cat;
    private String admin, vista, nombre;
    private int id;
    private CategoriaDao cDao;
    private String service;
    public ArrayList getArray_Cat() {
        return array_Cat;
    }

    public void setArray_Cat(ArrayList array_Cat) {
        this.array_Cat = array_Cat;
    }

    public Collection<Categoria> getlist_Cat() {
        return list_Cat;
    }

    public void setlist_Cat(List<Categoria> list_Cat) {
        this.list_Cat = list_Cat;
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

    public CategoriaDao getcDao() {
        return cDao;
    }

    public void setcDao(CategoriaDao cDao) {
        this.cDao = cDao;
    }
    
    
    
    @Override
    public String execute(){
        try {
            String resultado = SUCCESS;
            Conexion co = new Conexion("andaser", "root", "root");
            
            
            switch(service){
                case "insertar":
                    
                    
                    
                    break;
            }
            
            co.getAllCategoria();
            while (co.Obtener_Siguiente()){
                
                array_Cat.add(new Categoria(co.Obtener_ID_Actual("ID"),co.Obtener_Actual("NOMBRE") ));
                
            }
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
        
        ActionContext.getContext().getSession().put("vista","../views/adminCategoria.jsp");
        return SUCCESS;
    }
    
    
}
