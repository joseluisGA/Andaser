/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

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
          ActionContext.getContext().getSession().put("usuario", null);
          context.setAttribute("vista", "views/galeria.jsp");
        
        return SUCCESS;
    }
}
