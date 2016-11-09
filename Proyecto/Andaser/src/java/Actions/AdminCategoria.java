/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import com.opensymphony.xwork2.ActionSupport;

import Modelos.CategoriaDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
        String resultado = SUCCESS;
        cDao = new CategoriaDao();
        if(admin!=null){
            switch (admin){
                 case ("insertar"):
                
                break;
            }
        }
        
        if(cDao.loadAll()!=null){
        list_Cat = cDao.loadAll();
        Categoria aux = null;
        Iterator<Categoria> it = list_Cat.iterator();
        while(it.hasNext()){
            
            aux = it.next();
            this.id = aux.getId();
            this.nombre = aux.getNombre();
           
        }
        }
        return resultado;
    }
    
    
}
