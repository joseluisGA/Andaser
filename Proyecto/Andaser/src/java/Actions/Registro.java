/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Cliente;
import Modelos.Direccion;
import Modelos.Empresa;
import Modelos.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author minit
 */
public class Registro extends ActionSupport {

    private String usuario, email, dni, nombre, ape1, ape2, nif, calle, poblacion, provincia, pais;
    private int cp, tlfn1, tlfn2, rol, idDir;
    private Usuario user;
    private Direccion dir;
    private Cliente cli;
    private Empresa em;
    private String pass;

    
    static Properties properties = new Properties();
   static
   {
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
   }
   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTlfn1() {
        return tlfn1;
    }

    public void setTlfn1(int tlfn1) {
        this.tlfn1 = tlfn1;
    }

    public int getTlfn2() {
        return tlfn2;
    }

    public void setTlfn2(int tlfn2) {
        this.tlfn2 = tlfn2;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    private void EnviarCorreo(String to ) throws AddressException, MessagingException{
        Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {
            protected PasswordAuthentication 
            getPasswordAuthentication() {
            return new 
            PasswordAuthentication("minitrampi@gmail.com", "minitrampi94");
            }});

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("minitrampi@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse(to));
         message.setSubject("Solicitud de registro");
         message.setText("Se ha enviado su solicitud de usuario, en cuanto se confirme, "
                 + " se le notificará en un correo"
                 + " con su contraseña, la cual deberá cambiar."
                         + "\n"
                         + "\n"
                         + "\n"
                         + "\n"
                         + "\n"
                 + "Si ha recibido este correo por error, por favor conteste a este mismo mensaje y notifíquelo. Muchas gracias.");
         Transport.send(message);
    }

    private String generarPass() {
        String pass = "";

        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 12) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                pass += c;
                i++;
            }
        }

        return pass;
    }

    private String validar(String doc, int cp, int tlfn1, int tlfn2){
        String error ="";
        if(doc.length()!=9){
            error = "El documento de identificación debe tener 9 caracteres";
        }
        if(cp <10000 || cp>99999){
            if(error.equals("")){
            error = "El código postal debe tener 5 dígitos";
            }
            else{
                
                error = error + " \n El código postal debe tener 5 dígitos";
            }
        }
        if(tlfn1 <100000000 || tlfn1 >999999999){
              if(error.equals("")){
            error = "El teléfono debe tener 9 dígitos";
              }
              else{
                  error = error + " \n El teléfono debe tener 9 dígitos";
              }
        }
        if(tlfn2 !=0){
          if(tlfn2<100000000 || tlfn2 >999999999){
              if(error.equals("")){
            error = "El teléfono debe tener 9 dígitos";
              }
              else{
                  error = error + " \n El teléfono debe tener 9 dígitos";
              }
        }  
        }
        



        return error;
    }
    @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, SQLException, MessagingException {
        Conexion co = new Conexion("andaser", "root", "root");
        ServletContext context = ServletActionContext.getServletContext();
        String error="";
        ///////////////Validación de los campos////////////////////////////////
        if(dni!=null){
         error= this.validar(dni, cp, tlfn1, tlfn2);
                }
        else{
            error = this.validar(nif, cp, tlfn1, tlfn2);
        }
       if(error.equals("")){
        co.existeUsuario(this.usuario);

        if (!co.Obtener_Siguiente()) {
            co.existeEmail(email);
            if (!co.Obtener_Siguiente()) {
                this.pass = generarPass();
                user = new Usuario(this.usuario, this.pass, this.email, this.rol);
                if (tlfn2 == 0) {
                    dir = new Direccion(calle, poblacion, provincia, pais, cp, tlfn1);
                } else {
                    dir = new Direccion(calle, poblacion, provincia, pais, cp, tlfn1, tlfn2);
                }
                switch (this.rol) {
                    case 2:
                        co.existeCliente(dni);
                        if(!co.Obtener_Siguiente()){
                        user.setRol(this.rol);
                        cli = new Cliente(dni, nombre, ape1, ape2);
                        cli.setUser(user);
                        cli.setDir(dir);
                        co.insertarDireccion(dir);
                        co.getIdDireccion(dir);
                        if(co.Obtener_Siguiente()){
                            this.idDir = co.Obtener_ID_Actual("ID");
                        }
                        co.insertarUsuario(user);
                        
                        co.insertarCliente(cli, idDir);
                        this.EnviarCorreo(this.email);
                        
                        }
                        break;
                    
                    case 3:
                        co.existeEmpresa(nif);
                        if(!co.Obtener_Siguiente()){
                            user.setRol(this.rol);
                            em = new Empresa(nif, nombre);
                            em.setUser(user);
                            em.setDir(dir);
                            co.insertarDireccion(dir);
                            co.getIdDireccion(dir);
                            if(co.Obtener_Siguiente()){
                                this.idDir = co.Obtener_ID_Actual("ID");
                            }
                            
                            co.insertarUsuario(user);
                            
                            co.insertarEmpresa(em, idDir);
                            this.EnviarCorreo(this.email);
                        }
                        
                        break;
                }
            }
            else{
                error = "El email introducido ya está registrado";
            ActionContext.getContext().getSession().put("error", error); 
            }
            
        }
        else{
            error = "El nombre de usuario introducido no está disponible";
            ActionContext.getContext().getSession().put("error", error);
        }
        if(error.equals("")){
         ActionContext.getContext().getSession().put("vista", "views/galeria.jsp");
         ActionContext.getContext().getSession().put("error", null); 
        }
       }
       else{
          ActionContext.getContext().getSession().put("error", error); 
       }
       
        return SUCCESS;
    }

}
