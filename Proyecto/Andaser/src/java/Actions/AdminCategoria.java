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
/**
 *
 * @author minit
 */
public class AdminCategoria extends ActionSupport{
    private ArrayList array_Cat;
    private Collection<Categoria> coll_Cat;
    private String admin, vista, nombre;
    private int id;
    private CategoriaDao cDao;

    public ArrayList getArray_Cat() {
        return array_Cat;
    }

    public void setArray_Cat(ArrayList array_Cat) {
        this.array_Cat = array_Cat;
    }

    public Collection<Categoria> getColl_Cat() {
        return coll_Cat;
    }

    public void setColl_Cat(Collection<Categoria> coll_Cat) {
        this.coll_Cat = coll_Cat;
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
        coll_Cat = cDao.loadAll();
        Categoria aux = null;
        Iterator<Categoria> it = coll_Cat.iterator();
        while(it.hasNext()){
            aux = it.next();
            array_Cat.add(new Categoria(aux.getId(), aux.getNombre()));
        }
        }
        return resultado;
    }
    
    
}
