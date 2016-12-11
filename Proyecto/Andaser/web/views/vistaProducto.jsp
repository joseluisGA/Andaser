<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %> 

<div class="col-md-12">
            <div class="col-md-11 col-md-push-1">
                <s:iterator value="#session.array_p"> 
                    <s:url action="../Redireccion.action" var="detallesPro" escapeAmp="false">
                        <s:param name="REF"><s:property value='REF'/></s:param>
                        <s:param name="template">detallesPro</s:param>
                    </s:url>
                    
                    
                    <div class="col-md-5 producto" style="  ">
                        <s:a href="%{detallesPro}">
                            <img src="img/<s:property value='imagen'/>" style="margin-top: 20px;"/>  
                        </s:a>
                        <!-- Creo un enlace con el action al que tiene que ir, para diferenciarlos se le da de nombre
                            el nombre de cada artículo, y le paso como parámentro el id correspondiente.
                        -->   
                        <div class="añadir">
                            <s:property value="nombre"/>
                            <s:if test="%{#session.usuario!=null}">
                                <s:if test="%{#session.usuario.rol==2}">
                                 <s:property value="precio1"/>€
                                </s:if>
                                <s:if test="%{#session.usuario.rol==3}">
                                    <s:property value="precio2"/>
                                </s:if>
                            </s:if>
                           
                        </div>
                    </div>
                </s:iterator>

            </div>
        </div>