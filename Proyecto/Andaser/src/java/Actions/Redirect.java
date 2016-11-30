/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class Redirect extends ActionSupport{
    private String template;
    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
    
    @Override
    public String execute(){
        ServletContext context = ServletActionContext.getServletContext();
        switch (template){
            case "login":
                context.setAttribute("vista", "views/acceso.jsp");
            break;
            
            case "registro":
                context.setAttribute(("vista"), "views/registro.jsp");
                break;
    }
        
        return SUCCESS;
    }
}
