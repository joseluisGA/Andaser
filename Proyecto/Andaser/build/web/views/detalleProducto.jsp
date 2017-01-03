
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >
        <div class="col-md-4 ">
            <img src="img/<s:property value='#session.producto.imagen'/>"/>
        </div>
        <div class="col-md-4">
            <p style="font-size: 24px;"><s:property value="#session.producto.nombre"/></p>
            <p>REF: <s:property value="#session.producto.REF"/></p>
            <p>Descripción: <s:property value="#session.producto.descripcion"/></p>
            <s:if test="%{#session.usuario!=null}">
                <s:if test="%{#session.usuario.rol==2}">
                    <p><s:property value="#session.producto.precio1"/>€</p>
                </s:if>
                <s:if test="%{#session.usuario.rol==3}">
                    <p><s:property value="#session.producto.precio2"/>€</p>
                </s:if>
            </s:if>
                    
                    <a href="pdf/<s:property value='#session.producto.ficha'/> " target="_blank">ficha</a>
                <hr/>
            <s:if test="%{#session.usuario!=null}">
                <s:form action="AdminPedido" cssClass="form-inline" theme="simple">

                    <s:hidden name="REF" value="%{#session.producto.REF}"/>
                    <s:hidden name="usuario" value="%{#session.usuario.nombre}"/>
                      <s:if test="%{#session.usuario.rol==2}">
                    <s:hidden name="precio" value="%{#session.producto.precio1}"/>
                    
                     </s:if>
                     <s:if test="%{#session.usuario.rol==3}">
                          <s:hidden name="precio" value="%{#session.producto.precio2}"/>
                     </s:if>
                      <div class="form-group" >
                          <s:textfield type="number" name="cantidad" cssClass="form-control" placeholder="Cantidad"  value="1"/>
                          <s:submit name="service" value="Agregar" cssClass="btn btn-default"/>
                       </div>
                    
                </s:form>
            </s:if>
        </div>
    
</div>