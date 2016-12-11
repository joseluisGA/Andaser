
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido">
    <div class="col-md-10 col-md-push-1">
        <s:if test="%{#session.pedido==null}">
            No hay ningún producto agregado al pedido aún
        </s:if>
        <s:else>
            <table class="table">
                <th>REF</th><th>Nombre</th><th>Cantidad</th><th>Precio</th>
                    <s:iterator value="#session.pedido.array_ped"> 
                    <tr>
                        <s:url action="../AdminPedido.action" var="urlBorrarPro">
                            <s:param name="service">borrarPro</s:param>
                            <s:param name="REF"><s:property value="REF"/></s:param>
                        </s:url>
                        <td><s:property value="REF"/></td>
                        <td><s:property value="nombrePro"/></td>
                        <td><s:property value="cantidad"/></td>
                        <td><s:property value="precio"/></td>
                        <td><s:a href="%{urlBorrarPro}"><button type="button" class="btn btn-default">Borrar</button></s:a></td>

                        </tr>

                </s:iterator>

                <tr>
                    <td></td><td></td><td>Precio total: </td><td><s:property value="#session.pedido.precio_total"/></td> 
                </tr>
                <s:url action="../AdminPedido.action" var="urlRealizarPed">
                    <s:param name="service">realizar</s:param>

                </s:url>
                <tr>
                    <td></td><td></td><td></td><td><s:a href="%{urlRealizarPed}"><button type="button" class="btn btn-default">Realizar</button></s:a></td>
                    </tr>
                </table>
        </s:else>

    </div>
</div>
</div>