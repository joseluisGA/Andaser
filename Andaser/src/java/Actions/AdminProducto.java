/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Categoria;
import Modelos.Producto;
import Modelos.Subcategoria;
import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class AdminProducto extends ActionSupport{
    Conexion co;
    private List<Producto> array_p = new ArrayList();
    private List<Categoria> array_c = new ArrayList();
    private List<Subcategoria> array_s = new ArrayList();
    private Producto pro;
    private String REF, nombre, descripcion,ficha, 
                    imagen, nombreCat, nombreSubCat, service, detalles;
    private int  precio1, precio2;

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    

   

    public void setService(String service) {
        this.service = service;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    
    public String getREF() {
        return REF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFicha() {
        return ficha;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public String getNombreSubCat() {
        return nombreSubCat;
    }

    public String getService() {
        return service;
    }

    public int getPrecio1() {
        return precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    
    
    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public void setNombreSubCat(String nombreSubCat) {
        this.nombreSubCat = nombreSubCat;
    }

    
    public void setREF(String REF) {
        this.REF = REF;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }

  
    
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        ServletContext context = ServletActionContext.getServletContext();
        Conexion co = new Conexion("andaser", "root", "root");
        
        if(service!=null){
            switch(service){
                case "insertar":
                    //Inserta un nuevo producto
                    co.InsertarProducto(REF, nombre, REF, nombreCat, nombreSubCat, precio1, precio2, ficha, imagen);
                     ActionContext.getContext().getSession().put(("vista"), "views/adminProducto.jsp");
                    break;
                case "modificar":
                    //Modifica un producto
                    
                    //Si no se ha pulsado el botón de detalles, recoge los datos del producto
                    if(detalles==null){
                    
                    co.GetProducto(REF);
                    if(co.Obtener_Siguiente()){
                        pro = new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"), co.Obtener_Actual("DESCRIPCION"),co.Obtener_ID_Actual("ID_CATEGORIA"), co.Obtener_ID_Actual("ID_SUBCATEGORIA"), co.Obtener_ID_Actual("PRECIO1"), co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN"));
                    }
                    ActionContext.getContext().getSession().put(("pro"), pro);
                    ActionContext.getContext().getSession().put(("vista"), "views/modProducto.jsp");
                    }
                    else{
                        //Si se ha detalles es true, significa que viene desde la página de detalle
                        //Por lo que modifica el producto
                        co.ModificarProducto(REF, nombre, descripcion, nombreCat, nombreSubCat, precio1, precio2, ficha, imagen);
                         ActionContext.getContext().getSession().put(("vista"), "views/adminProducto.jsp");
                    }
                    break;
                case "borrar":
                    //Borra un producto
                    co.BorrarProducto(REF);
                     ActionContext.getContext().getSession().put(("vista"), "views/adminProducto.jsp");
                    break;
                   
            }
            }
        else{
             ActionContext.getContext().getSession().put(("vista"), "views/adminProducto.jsp");
        }
        //Obtiene los productos 
         co.getAllCategoria();
         while (co.Obtener_Siguiente()){  
          
              array_c.add(new Categoria(co.Obtener_ID_Actual("ID"),co.Obtener_Actual("NOMBRE") ));  
             }
         Iterator<Categoria> it = array_c.iterator();
         Categoria aux;
         ArrayList<Categoria> aAux = new ArrayList();
         while(it.hasNext()){
             aux = it.next();
           co.getSubCategoria(aux.getId());
                while(co.Obtener_Siguiente()){
                  if(co.Obtener_Actual("ID")!=null){
                      array_s.add(new Subcategoria(co.Obtener_ID_Actual("ID"),aux.getId(), co.Obtener_Actual("NOMBRE")));
                      
                     aux.setSubcategoria((ArrayList<Subcategoria>) array_s);  
                  }  
                }
               
               aAux.add(aux);
         }
         array_c = aAux;
         
           
            ActionContext.getContext().getSession().put("aSubCat", array_s);
         co.GetAllProducto();
         while(co.Obtener_Siguiente()){
             array_p.add(new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"),
                     co.Obtener_Actual("DESCRIPCION"), co.Obtener_ID_Actual("ID_CATEGORIA"),
                     co.Obtener_ID_Actual("ID_SUBCATEGORIA"),co.Obtener_ID_Actual("PRECIO1"), co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN")));
         }
        ActionContext.getContext().getSession().put("aPro", array_p);
        
        return SUCCESS;
    }
    
}
