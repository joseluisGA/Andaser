/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class LogOut extends ActionSupport{
    
    
    @Override
    public String execute(){
         ServletContext context = ServletActionContext.getServletContext();
        Usuario user = (Usuario) ActionContext.getContext().getSession().get("usuario");
        if(user.getRol()==1){
            ActionContext.getContext().getSession().put(("pedido"),null);
            ActionContext.getContext().getSession().put(("aPro"),null);
            ActionContext.getContext().getSession().put(("objeto"),null);
            ActionContext.getContext().getSession().put(("objeto0"),null);
        }
          ActionContext.getContext().getSession().put("usuario", null);
          ActionContext.getContext().getSession().put("vista", "views/galeria.jsp");
        
        return SUCCESS;
    }
}
