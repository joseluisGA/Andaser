/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

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
public class AdminUsuario extends ActionSupport{
    private String usuario, password, email, service;
    private int rol;
    private List<Usuario> array_u = new ArrayList();
    private List<Usuario> array_u_0 = new ArrayList();

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
         ServletContext context = ServletActionContext.getServletContext();
        Conexion co = new Conexion("andaser", "root", "root");
        if(service!=null){
        switch(service){
            case "borrar":
                co.BorrarUser(usuario);
                
                break;
            case "confirmar":
                co.AceptarUsuario(usuario);
        }
        }
        co.getUsers();
        while(co.Obtener_Siguiente()){
            array_u.add(new Usuario(co.Obtener_Actual("NOMBRE"), null, co.Obtener_Actual("EMAIL"), co.Obtener_ID_Actual("ROL")));
        }
         co.getUserSinConfirmar();
        while(co.Obtener_Siguiente()){
            array_u_0.add(new Usuario(co.Obtener_Actual("NOMBRE"), null, co.Obtener_Actual("EMAIL"), co.Obtener_ID_Actual("ROL")));
        }
        context.setAttribute("objeto", array_u);
        context.setAttribute("objeto0", array_u_0);
        
        ActionContext.getContext().getSession().put(("vista"), "views/adminUsuario.jsp");
        
        
        return SUCCESS;
    }
    
}
