<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido">
     
            <table class="table">
                <th>Usuario</th><th>Documento identidad</th><th>Fecha</th><th>Precio</th>
                    <s:iterator value="#session.array_list_ped"> 
                    <tr>
                         <s:url action="../AdminPedido.action" var="urlDetallesPed">
                            <s:param name="service">detallesPed</s:param>
                            <s:param name="id"><s:property value="id"/></s:param>
                        </s:url>
                        <td><s:property value="usuario"/></td>
                        <td><s:property value="doc"/></td>
                        <td><s:property value="fecha"/></td>
                        <td><s:property value="precio_total"/></td>
                        <td><s:a href="%{urlDetallesPed}"><button type="button" class="btn btn-default">Detalles</button></s:a></td>
                        
                    </tr>
                        
                    </s:iterator>
                   
            </table>

</div>