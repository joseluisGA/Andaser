<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="JavaScript">
    function pregunta() {
        if (confirm('¿Estas seguro de borrar este usuario?')) {
            document.form.submit();
        }
    }

    $(document).ready(function(){
        $('#botonAyuda').on('click',function(){
            $('#ayuda').toggle();
        });
    });


</script>
<div class="col-md-12 contenido"  >

    <h2>Usuarios</h2>
     <a href="#" id="botonAyuda"><span class="glyphicon glyphicon-info-sign"></span></a>
    <div class="col-md-12">
        <div class="alert alert-success alert-dismissible" id="ayuda" role="alert"
             style="display: none;">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
            <p>Los estados corresponden:</p>
            <br/>
            <p>Usuario confirmado: <span style="color:green" class="glyphicon glyphicon-ok"></span></p>
            <p>Usuario pendiente: <span style="color:yellow" class="glyphicon glyphicon-warning-sign"></span></p>
            <p>Usuario rechazado: <span style="color:red" class="glyphicon glyphicon-remove"></span></p>

        </div>
    </div>
    <table class="table">
        <thead>
        <th>Usuario</th><th>Email</th><th>Tipo</th><th>Estado</th>
        </thead>
        <s:iterator value="#session.objeto">
            <tr>

                <s:url action="../AdminUsuario.action" var="urlBorrar">
                    <s:param name="service">borrar</s:param>
                    <s:param name="usuario"><s:property value="nombre"/></s:param>
                </s:url>
                <s:url action="../AdminUsuario.action" var="urlDetalles">
                    <s:param name="service">detalles</s:param>
                    <s:param name="usuario"><s:property value="nombre"/></s:param>
                    <s:param name="rol"><s:property value="rol"/></s:param>
                </s:url>
                    
                <td><s:property value="nombre"/></td>
                <td><s:property value="email"/></td>
                <s:if test="%{rol==2}">
                    <td>Particular</td>
                </s:if>
                <s:if test="%{rol==3}">
                    <td>Empresa</td>
                </s:if>
                <s:if test="%{estado==0}">
                    <td><span style="color:yellow" class="glyphicon glyphicon-warning-sign"></span></td>
                    </s:if>
                    <s:if test="%{estado==1}">
                    <td> <span style="color:green" class="glyphicon glyphicon-ok"></span></td>
                    </s:if>
                    <s:if test="%{estado==2}">
                    <td> <span style="color:red" class="glyphicon glyphicon-remove"></span></td>
                    </s:if>
                <td>
                    <s:a href="%{urlBorrar}" onclick="pregunta()" cssClass="confirmar"><input type="button"  value="borrar" class="btn btn-default"/></s:a>
                    </td>
                    <td>
                    <s:a href="%{urlDetalles}"><input type="button" value="detalles" class="btn btn-default"/></s:a> 
                    </td>

                </tr>
        </s:iterator>
    </table>






</div>
