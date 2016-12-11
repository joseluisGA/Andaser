<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >
        <div class="col-md-6">
            <h2>Borrar Usuario</h2>

            <s:iterator value="#session.objeto">
                <s:form action="AdminUsuario" cssClass="form-horizontal" theme="simple">
                    <div class="col-md-4">Usuario: </div> 
                    <div class="col-md-4"><s:property value="nombre"/></div>
                   
                    <s:hidden value="%{nombre}" name="usuario"/>
                    <div class="col-md-4"><s:submit name="service" value="borrar" cssClass="btn btn-default"/></div>

                </s:form>
                <hr/>
            </s:iterator>
                

        </div>
        <div class="col-md-6">
            <h2>Confirmar Usuario</h2>

            <s:iterator value="#session.objeto0">
                <s:form action="AdminUsuario" cssClass="form-horizontal" theme="simple">
                    <div class="col-md-4">Usuario: </div> 
                    <div class="col-md-4"><s:property value="nombre"/></div>
                    
                    <s:hidden value="%{nombre}" name="usuario"/>
                    <div class="col-md-4"><s:submit name="service" value="confirmar" cssClass="btn btn-default"/></div>

                </s:form>
                <hr/>
            </s:iterator>
                

        </div>
        
    </div>
