/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Modelos.Direccion;
import Modelos.ListaPedido;
import Modelos.Pedido;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author minit
 */
public class AdminPedido extends ActionSupport {

    private int id,id_dir, precio, confirmado, cantidad, precio_total, pos =0;
    private String REF, usuario, DOC, service, nombrePro, fecha_proceso;
    private Date fecha = new Date();
    private List<Pedido> array_ped = new ArrayList();
    private List<ListaPedido> array_list_ped = new ArrayList();
    private ListaPedido list_ped;
    private PdfWriter pdfWriter;
    private Document document;
    
    
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDOC() {
        return DOC;
    }

    public void setDOC(String DOC) {
        this.DOC = DOC;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String execute() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ServletContext context = ServletActionContext.getServletContext();
        Conexion co = new Conexion("andaser", "root", "root");
        if (service != null) {
            switch (service) {
                case "Agregar":
                    co.GetProducto(REF);
                    if(co.Obtener_Siguiente()){
                        this.nombrePro = co.Obtener_Actual("NOMBRE");
                        
                    }
                    
                    co.getCliente(usuario);
                    if(co.Obtener_Siguiente()){
                        this.DOC = co.Obtener_Actual("DNI");
                        this.id_dir = co.Obtener_ID_Actual("ID_DIRECCION");
                    }
                    else{
                        co.getEmpresa(usuario);
                        if(co.Obtener_Siguiente()){
                            this.DOC = co.Obtener_Actual("NIF");
                            this.id_dir = co.Obtener_ID_Actual("ID_DIRECCION");
                        }
                    }
                    this.precio = this.precio * this.cantidad;
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                        fecha_proceso = dt.format(fecha);
                    if(ActionContext.getContext().getSession().get("pedido")==null){
                        array_ped.add(new Pedido(precio, cantidad, REF, nombrePro));
                        list_ped = new ListaPedido(id_dir, precio_total, usuario, DOC, fecha_proceso);
                        if(list_ped.getPrecio_total()==0){
                            list_ped.setPrecio_total(precio);
                        }
                        else{
                            list_ped.setPrecio_total(list_ped.getPrecio_total() + precio);
                        }
                        list_ped.setArray_ped(array_ped);
                        
                        
                    ActionContext.getContext().getSession().put(("pedido"), list_ped);
                    }
                    else{
                        list_ped = (ListaPedido) ActionContext.getContext().getSession().get("pedido");
                        array_ped = list_ped.getArray_ped();
                        
                         array_ped.add(new Pedido(precio, cantidad, REF, nombrePro));
                          list_ped.setPrecio_total(list_ped.getPrecio_total() + precio);
                         list_ped.setArray_ped(array_ped);
                         
                          ActionContext.getContext().getSession().put(("pedido"), list_ped);
                    }
                    break;
                case "realizar":
                     list_ped = (ListaPedido) ActionContext.getContext().getSession().get("pedido");
                      array_ped = list_ped.getArray_ped();
                   co.AgregarListaPedido(list_ped.getUsuario(),list_ped.getDoc(), list_ped.getIdDir(), list_ped.getFecha(), list_ped.getPrecio_total());
                    for (Pedido ped : array_ped){
                       co.AgregarPedido(ped.getREF(),list_ped.getUsuario(), list_ped.getDoc()
                               , list_ped.getIdDir(), ped.getPrecio(), ped.getCantidad(), list_ped.getFecha(), list_ped.getPrecio_total());
                    }
                    ActionContext.getContext().getSession().put(("pedido"),null);
                    ActionContext.getContext().getSession().put(("vista"), "views/galeria.jsp");
                    break;
                    case "mostrar":
                        
                        ActionContext.getContext().getSession().put(("vista"), "views/pedido.jsp");
                    break;
                    case "borrarPro":
                        list_ped = (ListaPedido) ActionContext.getContext().getSession().get("pedido");
                        array_ped = list_ped.getArray_ped();
                    
                        int posBorrar=0;
                        int precioPro=0;
                        for(Pedido pedido : array_ped){
                            if(pedido.getREF().equals(REF)){
                                precioPro = pedido.getPrecio();
                              posBorrar = pos;  
                            }
                            pos++;
                        }
                        list_ped.setPrecio_total(list_ped.getPrecio_total() - precioPro);
                        
                        array_ped.remove(posBorrar);
                        if(array_ped.size()==0){
                            ActionContext.getContext().getSession().put(("pedido"),null);
                        }
                        else{
                        list_ped.setArray_ped(array_ped);
                        ActionContext.getContext().getSession().put(("pedido"),list_ped);
                        }
                        break;
                    case "adminPed":
                        co.getAllPedido();
                        while(co.Obtener_Siguiente()){
                            this.array_list_ped.add(new ListaPedido(
                                    co.Obtener_ID_Actual("ID"), co.Obtener_ID_Actual("ID_DIR"),
                                    co.Obtener_ID_Actual("PRECIO_TOTAL"),
                                    co.Obtener_Actual("USUARIO"),
                                    co.Obtener_Actual("DNI_NIF"),
                                    (String)co.Obtener_Actual("FECHA")));
                            this.id = co.Obtener_ID_Actual("ID");
                            
                            
                        }
                       for(ListaPedido lista : this.array_list_ped){
                           co.getProductoPed(lista.getId());
                           while(co.Obtener_Siguiente()){
                                this.array_ped.add(new Pedido(co.Obtener_ID_Actual("ID"),
                                        lista.getId(), 
                                        co.Obtener_ID_Actual("PRECIO"), co.Obtener_ID_Actual("CANTIDAD"),
                                        co.Obtener_Actual("REF"), co.Obtener_Actual("NOMBRE")));
                                
                            }
                           lista.setArray_ped(array_ped);
                       }
                       ActionContext.getContext().getSession().put(("array_list_ped"), array_list_ped);
                       ActionContext.getContext().getSession().put(("vista"), "views/adminPedido.jsp");
                        break;
                        
                    case "detallesPed":
                        this.array_list_ped =  (List<ListaPedido>)ActionContext.getContext().getSession().get(("array_list_ped"));
                        for(ListaPedido lista : this.array_list_ped){
                            if(lista.getId()==this.id){
                                co.getDireccion(lista.getIdDir());
                                if(co.Obtener_Siguiente()){
                                    lista.setDir(new Direccion(co.Obtener_Actual("CALLE"), co.Obtener_Actual("POBLACION"), 
                                            co.Obtener_Actual("PROVINCIA"), co.Obtener_Actual("PAIS"), 
                                            co.Obtener_ID_Actual("CODIGO_POSTAL"), co.Obtener_ID_Actual("TLFN1"),
                                            co.Obtener_ID_Actual("TLFN2")));
                                    
                                }
                                ActionContext.getContext().getSession().put(("detalle"), lista);
                                ActionContext.getContext().getSession().put(("vista"), "views/detallePedido.jsp");
                            }
                        }
                        
                        
                        break;
            }   
        }

        return SUCCESS;
    }
}
