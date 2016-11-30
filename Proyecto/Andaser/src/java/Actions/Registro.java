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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class Registro extends ActionSupport {

    private String usuario, email, dni, nombre, ape1, ape2, nif, calle, poblacion, provincia, pais;
    private int cp, tlfn1, tlfn2, rol;
    private Usuario user;
    private Direccion dir;
    private Cliente cli;
    private Empresa em;
    private String pass;

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

    @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, SQLException {
        Conexion co = new Conexion("andaser", "root", "root");
        ServletContext context = ServletActionContext.getServletContext();
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
                            
                        cli = new Cliente(dni, nombre, ape1, ape2);
                        cli.setUser(user);
                        cli.setDir(dir);
                        
                        }
                        break;
                }
            }
        }
        return SUCCESS;
    }

}
