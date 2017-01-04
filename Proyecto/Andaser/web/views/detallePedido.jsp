<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido">
            Usuario <s:property value="#session.detalle.usuario"/><hr/>
            Dirección<hr/>
            <p> Calle: <s:property value="#session.detalle.dir.calle"/></p>
            <p> Población: <s:property value="#session.detalle.dir.poblacion"/></p>
            <p> Código Postal: <s:property value="#session.detalle.dir.cp"/></p>
            <p> Provincia: <s:property value="#session.detalle.dir.provincia"/></p>
             <table class="table">
                <th>REF</th><th>Nombre</th><th>Cantidad</th><th>Precio</th>
            <s:iterator value="#session.detalle.array_ped">
            <tr>
                 <td><s:property value="REF"/></td>
                        <td><s:property value="nombrePro"/></td>
                        <td><s:property value="cantidad"/></td>
                        <td><s:property value="precio"/>€</td>
            </tr>
            </s:iterator>
            <tr>
                        <td></td><td></td><td>Precio total: </td><td><s:property value="#session.detalle.precio_total"/>€</td> 
                    </tr>
             </table>
        </div>

