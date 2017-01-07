/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Producto;
import Modelos.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class Redirect extends ActionSupport{
    private String template, pass1, pass2;
    private String rol;
    private int idCat, idSubCat;
    private String busqueda, REF;
    private List<Producto> array_p = new ArrayList();
    private Producto proDetalles;

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    
    
    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getIdSubCat() {
        return idSubCat;
    }

    public void setIdSubCat(int idSubCat) {
        this.idSubCat = idSubCat;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
   
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
    
    @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        ServletContext context = ServletActionContext.getServletContext();
        Conexion co = new Conexion("andaser", "root", "root");
        ActionContext.getContext().getSession().put("error", null);
        if(template!=null){
        switch (template){
            case "login":
                 ActionContext.getContext().getSession().put("vista", "views/acceso.jsp");
            break;
            case "Cambiar":
               if(this.pass1.equals(this.pass2)){
                  Usuario user = (Usuario) ActionContext.getContext().getSession().get("usuarioSP");
                  co.CambiarPass(pass1, user.getNombre());
                  ActionContext.getContext().getSession().put("usuario", user);
                  ActionContext.getContext().getSession().put("usuarioSP", null);
                  ActionContext.getContext().getSession().put("vista", "views/galeria.jsp");
               }
               else{
                   ActionContext.getContext().getSession().put(("vista"), "views/cambiarPass.jsp");
                   ActionContext.getContext().getSession().put(("error"), "Las contraseñas no coinciden");
               }
               break;
            case "registro":
                 ActionContext.getContext().getSession().put(("rol"), rol);
                 ActionContext.getContext().getSession().put(("vista"), "views/registro.jsp");
                break;
            
            case "ProductoCat":
                co.getProductoCat(idCat);
                while(co.Obtener_Siguiente()){
             array_p.add(new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"),
                     co.Obtener_Actual("DESCRIPCION"), co.Obtener_ID_Actual("ID_CATEGORIA"),
                     co.Obtener_ID_Actual("ID_SUBCATEGORIA"),co.Obtener_ID_Actual("PRECIO1"), co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN")));
         }
                 ActionContext.getContext().getSession().put(("vista"), "views/vistaProducto.jsp");
                 ActionContext.getContext().getSession().put(("array_p"), array_p);
                break;
            
            case "ProductoSubCat":
                co.getProductoSubCat(idSubCat);
                 while(co.Obtener_Siguiente()){
             array_p.add(new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"),
                     co.Obtener_Actual("DESCRIPCION"), co.Obtener_ID_Actual("ID_CATEGORIA"),
                     co.Obtener_ID_Actual("ID_SUBCATEGORIA"),co.Obtener_ID_Actual("PRECIO1"), co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN")));
         }
                 ActionContext.getContext().getSession().put(("vista"), "views/vistaProducto.jsp");
                 ActionContext.getContext().getSession().put(("array_p"), array_p);
                break;
            case "Buscar":
                co.getBusqueda(busqueda);
                 while(co.Obtener_Siguiente()){
             array_p.add(new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"),
                     co.Obtener_Actual("DESCRIPCION"), co.Obtener_ID_Actual("ID_CATEGORIA"),
                     co.Obtener_ID_Actual("ID_SUBCATEGORIA"),co.Obtener_ID_Actual("PRECIO1"),
                     co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN")));
         }
                 ActionContext.getContext().getSession().put(("vista"), "views/vistaProducto.jsp");
                 ActionContext.getContext().getSession().put(("array_p"), array_p);
                break;
            case "detallesPro":
                co.GetProducto(REF);
                if(co.Obtener_Siguiente()){
                    this.proDetalles = new Producto(co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE"),
                     co.Obtener_Actual("DESCRIPCION"), co.Obtener_ID_Actual("ID_CATEGORIA"),
                     co.Obtener_ID_Actual("ID_SUBCATEGORIA"),co.Obtener_ID_Actual("PRECIO1"),
                     co.Obtener_ID_Actual("PRECIO2"), co.Obtener_Actual("FICHA"), co.Obtener_Actual("IMAGEN"));
                    
                }
                ActionContext.getContext().getSession().put(("producto"), proDetalles);
                 ActionContext.getContext().getSession().put(("vista"), "views/detalleProducto.jsp");
                break;
                
    }
        }
        return SUCCESS;
    }
}
