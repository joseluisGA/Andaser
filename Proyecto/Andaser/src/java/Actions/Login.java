/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;
import com.opensymphony.xwork2.ActionContext;

import Modelos.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;


/**
 *
 * @author minit
 */

public class Login extends ActionSupport{
  
    private String user;
    private String password;
    private Usuario usuario;
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException{
        Conexion co = new Conexion("andaser", "root", "root");
        String resultado = SUCCESS;
        ServletContext context = ServletActionContext.getServletContext();
        
       
        co.Login(user, password);
        if(co.Obtener_Siguiente()){
            co.getUser(user);
            if(co.Obtener_Siguiente()){
                usuario = new Usuario(co.Obtener_Actual("NOMBRE"), co.Obtener_Actual("PASSWORD"), co.Obtener_Actual("EMAIL"), co.Obtener_ID_Actual("ROL"));
                ActionContext.getContext().getSession().put("usuario", this.usuario);
                ActionContext.getContext().getSession().put("errorlogin", null);
                if(co.Obtener_ID_Actual("ContrasenyaCambiada")==0){
                    ActionContext.getContext().getSession().put("PassCambiada", 0);
                    context.setAttribute("vista", "../views/cambiarPass.jsp");
                   
                }
                else{
                context.setAttribute("vista", "../views/index.jsp");
                }
            }
            else{
                 context.setAttribute("vista", "../views/acceso.jsp");
                ActionContext.getContext().getSession().put("errorlogin", "El nombre de usuario o la contraseña es incorrecta");
                resultado = ERROR;
            }
        }
        
        
        
        return resultado;
    }
    
}
