/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import static Actions.Registro.properties;
import Modelos.Cliente;
import Modelos.Direccion;
import Modelos.Empresa;
import Modelos.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class AdminUsuario extends ActionSupport {

    private String usuario, password, email, service, motivo;
    private int rol;
    private List<Usuario> array_u = new ArrayList();
    private List<Usuario> array_u_0 = new ArrayList();
    private Usuario user;
    private Cliente cli;
    private Empresa emp;
    private Direccion dir;
    static Properties properties = new Properties();

    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    private void EnviarCorreo(String to, String mensaje) throws AddressException, MessagingException {
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication
                    getPasswordAuthentication() {
                return new PasswordAuthentication("minitrampi@gmail.com", "");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("minitrampi@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject("Solicitud de registro");
        message.setText(mensaje);
        Transport.send(message);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

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

    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, MessagingException {
        ServletContext context = ServletActionContext.getServletContext();
        Conexion co = new Conexion("andaser", "root", "root");
        if (service != null) {
            switch (service) {
                case "borrar":
                    co.BorrarUser(usuario);

                    break;
                case "confirmar":
                    co.AceptarUsuario(usuario);
                    co.getUser(usuario);
                    if (co.Obtener_Siguiente()) {
                        this.password = co.Obtener_Actual("PASSWORD");
                        String mensaje = "Gracias por su solicitud de registro en www.comercialandaser.es."
                                + "\n "
                                + "Su usuario es: " + this.usuario
                                + "\n"
                                + "Su contraseña es: " + this.password + " \n "
                                + "En su próximo inicio de sesión podrá cambiarla."
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "Si ha recibido este correo por error, por favor conteste a este mismo mensaje y notifíquelo. Muchas gracias.";
                        this.EnviarCorreo(co.Obtener_Actual("EMAIL"), mensaje);
                    }
                    break;
                case "Rechazar":
                    co.RechazarUsuario(usuario);
                    co.getUser(usuario);
                    if (co.Obtener_Siguiente()) {
                        String mensaje = "Lamentablemente su usuario: " + usuario + " ha sido rechazado"
                                + "\n"
                                + "El motivo es el siguiente: "
                                + motivo
                                + "\n"
                                + "Si desea obtener más información, conteste a este mismo correo"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "Si ha recibido este correo por error, por favor conteste a este mismo mensaje y notifíquelo. Muchas gracias.";
                        this.EnviarCorreo(co.Obtener_Actual("EMAIL"), mensaje);
                    }
                case "detalles":
                    if (rol == 2) {
                        co.getCliente_Direccion(usuario);
                        if (co.Obtener_Siguiente()) {
                            user = new Usuario(usuario, co.Obtener_Actual("EMAIL"), rol, co.Obtener_ID_Actual("USUARIOCONFIRMADO"));
                            cli = new Cliente(co.Obtener_Actual("DNI"), co.Obtener_Actual("NOMBRE"), co.Obtener_Actual("APELLIDO1"), co.Obtener_Actual("APELLIDO2"));
                            dir = new Direccion(co.Obtener_Actual("CALLE"), co.Obtener_Actual("POBLACION"), co.Obtener_Actual("PROVINCIA"), co.Obtener_Actual("PAIS"), co.Obtener_ID_Actual("CODIGO_POSTAL"), co.Obtener_ID_Actual("TLFN1"), co.Obtener_ID_Actual("TLFN2"));
                            cli.setDir(dir);
                            user.setCli(cli);
                        }
                        ActionContext.getContext().getSession().put("objeto", user);

                    }
                    if (rol == 3) {
                        co.getEmpresa_Direccion(usuario);
                        if (co.Obtener_Siguiente()) {
                            user = new Usuario(usuario, co.Obtener_Actual("EMAIL"), rol, co.Obtener_ID_Actual("USUARIOCONFIRMADO"));
                            emp = new Empresa(co.Obtener_Actual("NIF"), co.Obtener_Actual("NOMBRE_EMPRESA"));
                            dir = new Direccion(co.Obtener_Actual("CALLE"), co.Obtener_Actual("POBLACION"), co.Obtener_Actual("PROVINCIA"), co.Obtener_Actual("PAIS"), co.Obtener_ID_Actual("CODIGO_POSTAL"), co.Obtener_ID_Actual("TLFN1"), co.Obtener_ID_Actual("TLFN2"));
                            emp.setDir(dir);
                            user.setEmp(emp);
                        }
                        ActionContext.getContext().getSession().put("objeto", user);

                    }
                    ActionContext.getContext().getSession().put(("vista"), "views/detallesUsuario.jsp");
                    break;

            }
        } else {
            if (service == null || service.equals("borrar")) {
                co.getUsers();
                while (co.Obtener_Siguiente()) {
                    if (!co.Obtener_Actual("NOMBRE").equals("admin")) {
                        array_u.add(new Usuario(co.Obtener_Actual("NOMBRE"), null, co.Obtener_Actual("EMAIL"), co.Obtener_ID_Actual("ROL"), co.Obtener_ID_Actual("USUARIOCONFIRMADO")));
                    }
                }

                ActionContext.getContext().getSession().put("objeto", array_u);

                ActionContext.getContext().getSession().put(("vista"), "views/adminUsuario.jsp");
            }
        }
        return SUCCESS;
    }

}
