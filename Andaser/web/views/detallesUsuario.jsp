<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="col-md-12 contenido"  >

    <s:if test="#session.objeto.rol==2">
        <div class="col-md-12">
            <h3>Usuario: </h3>  <s:property value="#session.objeto.nombre"/>
            <h4>Email: </h4> <s:property value="#session.objeto.email"/>
            <h4>Tipo de usuario: </h4>particular
        </div>
        <br/>
        <hr/>
        <div class="col-md-6">
            <h2>Datos del cliente</h2>
            <h4>Nombre completo: </h4><s:property value="#session.objeto.cli.nombre"/> <s:property value="#session.objeto.cli.ape1"/> <s:property value="#session.objeto.cli.ape2"/>
            <h4>NIF:</h4><s:property value="#session.objeto.cli.dni"/>
            <br/>
            <br/>
            <hr/>
            Usuario pendiente de confirmar
            <hr/>

            <s:if test="#session.objeto.estado ==0">

                <s:url action="../AdminUsuario.action" var="urlConfirmarUsu">
                    <s:param name="service">confirmar</s:param>
                    <s:param name="usuario"><s:property value="#session.objeto.nombre"/></s:param>

                </s:url>
                <s:url action="../AdminUsuario.action" var="urlRechazarUsu">
                    <s:param name="service">rechazar</s:param>
                    <s:param name="usuario"><s:property value="#session.objeto.nombre"/></s:param>

                </s:url>
                <div class="col-md-6">
                    <s:a href="%{urlConfirmarUsu}"><input type="button"  value="Confirmar" class="btn btn-default"/></s:a>
                    </div>
                    <div class="col-md-6">
                    <s:a href="%{urlRechazarUsu}"><input type="button"  value="Rechazar" class="btn btn-default"/></s:a>
                    </div>
            </s:if>
        </div>
        <div class="col-md-6">
            <h2>Dirección </h2>
            <div class="col-md-6">
                <h4>Calle: </h4><s:property value="#session.objeto.cli.dir.calle"/>
                <h4>Población: </h4><s:property value="#session.objeto.cli.dir.poblacion"/>
                <h4>Provincia: </h4><s:property value="#session.objeto.cli.dir.provincia"/>
                <h4>Código postal</h4><s:property value="#session.objeto.cli.dir.cp"/>
            </div>
            <div class="col-md-6">
                <h4>Pais: </h3><s:property value="#session.objeto.cli.dir.pais"/>
                    <h4>Teléfono 1:</h4><s:property value="#session.objeto.cli.dir.tlfn1"/>
                    <s:if test="%{#session.objeto.cli.dir.tlfn2!=null}">
                        <h4>Teléfono 2:</h4><s:property value="#session.objeto.cli.dir.tlfn2"/>
                </div>
            </s:if>
        </div>

    </s:if>
    <s:if test="#session.objeto.rol==3">
        <div class="col-md-12">
            <h3>Usuario: </h3>  <s:property value="#session.objeto.nombre"/>
            <h4>Email: </h4> <s:property value="#session.objeto.email"/>
            <h4>Tipo de usuario: </h4>empresa
            <div class="col-md-6">
                <h2>Datos de la empresa</h2>
                <h4>Nombre: </h4><s:property value="#session.objeto.emp.nombre"/> 
                <h4>NIF:</h4><s:property value="#session.objeto.cli.nif"/>
                <br/>
                <br/>
                <hr/>
                Usuario pendiente de confirmar
                <hr/>

                <s:if test="#session.objeto.estado ==0">

                    <s:url action="../AdminUsuario.action" var="urlConfirmarUsu">
                        <s:param name="service">confirmar</s:param>
                        <s:param name="usuario"><s:property value="#session.objeto.nombre"/></s:param>

                    </s:url>
                    <s:url action="../AdminUsuario.action" var="urlRechazarUsu">
                        <s:param name="service">rechazar</s:param>
                        <s:param name="usuario"><s:property value="#session.objeto.nombre"/></s:param>

                    </s:url>
                    <div class="col-md-3">
                        <s:a href="%{urlConfirmarUsu}"><input type="button"  value="Confirmar" class="btn btn-default"/></s:a>
                        </div>
                        <div class="col-md-9">
                        <s:form action="AdminUsuario" cssClass="form-horizontal">
                            <s:hidden name="usuario" value="%{session.objeto.nombre}"/>
                            <s:submit name="service" value="Rechazar" cssClass="btn btn-default"/>
                            <s:textarea name="motivo" label="motivo de rechazo" cols="30" rows="8" cssClass="form-control" required="true"/>
                        </s:form>
                    </div>
                </s:if>
            </div>
            <div class="col-md-6">
                <h2>Dirección </h2>
                <div class="col-md-6">
                    <h4>Calle: </h4><s:property value="#session.objeto.emp.dir.calle"/>
                    <h4>Población: </h4><s:property value="#session.objeto.emp.dir.poblacion"/>
                    <h4>Provincia: </h4><s:property value="#session.objeto.emp.dir.provincia"/>
                    <h4>Código postal</h4><s:property value="#session.objeto.emp.dir.cp"/>
                </div>
                <div class="col-md-6">
                    <h4>Pais: </h4><s:property value="#session.objeto.emp.dir.pais"/>
                    <h4>Teléfono 1:</h4><s:property value="#session.objeto.emp.dir.tlfn1"/>
                    <s:if test="%{#session.objeto.emp.dir.tlfn2!=null}">
                        <h4>Teléfono 2:</h4><s:property value="#session.objeto.emp.dir.tlfn2"/>
                    </div>
                </s:if>
            </div>

        </s:if>


    </div>