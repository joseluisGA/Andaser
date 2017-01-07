<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="JavaScript">


    $(document).ready(function () {
        $('#botonAyuda').on('click', function () {
            $('#ayuda').toggle();
        });
    });


</script>
<div class="col-md-12 contenido">
    <h2>Pedidos</h2>
    
    <div class="col-md-12">
         <a href="#" id="botonAyuda"><span class="glyphicon glyphicon-info-sign"></span></a>
        <div class="alert alert-success alert-dismissible" id="ayuda" role="alert"
             style="display: none;">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
            <p>Los estados corresponden:</p>
            <br/>
            <p>Pedido confirmado: <span style="color:green" class="glyphicon glyphicon-ok"></span></p>
            <p>Pedido pendiente: <span style="color:yellow" class="glyphicon glyphicon-warning-sign"></span></p>
            <p>Pedido rechazado: <span style="color:red" class="glyphicon glyphicon-remove"></span></p>

        </div>
    </div>
    <table class="table">
        <th>Usuario</th><th>Documento</th><th>Fecha</th><th>Estado</th><th>Precio</th>
            <s:iterator value="#session.array_list_ped"> 
            <tr>
                <s:url action="../AdminPedido.action" var="urlDetallesPed">
                    <s:param name="service">detallesPed</s:param>
                    <s:param name="id"><s:property value="id"/></s:param>
                </s:url>
                <td><s:property value="usuario"/></td>
                <td><s:property value="doc"/></td>
                <td><s:property value="fecha"/></td>
                <s:if test="%{aceptado==0}">
                    <td><span style="color:yellow" class="glyphicon glyphicon-warning-sign"></span></td>
                    </s:if>
                    <s:if test="%{aceptado==1}">
                    <td> <span style="color:green" class="glyphicon glyphicon-ok"></span></td>
                    </s:if>
                    <s:if test="%{aceptado==2}">
                    <td> <span style="color:red" class="glyphicon glyphicon-remove"></span></td>
                    </s:if>
                <td><s:property value="precio_total"/></td>
                <td><s:a href="%{urlDetallesPed}"><button type="button" class="btn btn-default">Detalles</button></s:a></td>

                </tr>

        </s:iterator>

    </table>

</div>