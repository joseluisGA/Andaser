
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12" style="padding:2%">
    <div class="content col-md-10 col-md-push-1" style="background-color: white;">
        <div class="col-md-8 col-md-push-4">
            <img src="img/<s:property value='#session.producto.imagen'/>"/>
            <p><s:property value="#session.producto.REF"/></p>
            <p><s:property value="#session.producto.nombre"/></p>
            <p><s:property value="#session.producto.descripcion"/></p>
            <s:if test="%{#session.usuario!=null}">
                <s:if test="%{#session.usuario.rol==2}">
                    <p><s:property value="precio1"/>€</p>
                </s:if>
                <s:if test="%{#session.usuario.rol==3}">
                    <p><s:property value="precio2"/>€</p>
                </s:if>
            </s:if>
            <s:a href="pdf/%{#session.producto.ficha}">ficha</s:a>
            <hr/>
            <s:url action="../pedido" var="urlPedido" escapeAmp="false">
                <s:param name="accion">Aniadir</s:param>
                <s:param name="REF"><s:property value="%{#producto.REF}"/></s:param>
            </s:url>
            <s:a href="%{urlPedido}"><button class="btn btn-default">Añadir</button></s:a>
        </div>
    </div>
</div>