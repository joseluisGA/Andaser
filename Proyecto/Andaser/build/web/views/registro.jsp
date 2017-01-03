<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div ng-controller="registro">
    <div class="col-md-6 col-md-offset-3">


        <div class="panel panel-default">
            <s:if test="#session.rol==2">
                <div class="panel-heading">Registro de particular</div>
                <div class="panel-body" >
                    <s:if test="#session.error!=null">
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                                <s:property value="#session.error"/>
                        </div>
                    </s:if>
                    <s:form action="registro" name="registro"  validate="true">
                        <s:hidden name="rol" value="2"/>
                        <div class="form-group"  >
                            <s:textfield name="usuario" type="text" label="Nombre de usuario"   placeholder="usuario" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group"  >
                            <s:textfield name="email" type="email" label="Email"   placeholder="email" cssClass="form-control" required="true"/>

                        </div>
                        <div class="form-group" >
                            <s:textfield name="dni" type="text"  maxLength="9" label="DNI"  placeholder="DNI" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="nombre" type="text" label="Nombre"  placeholder="Nombre" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="ape1" type="text" label="Primer apellido"  placeholder="Primer apellido" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="ape2" type="text" label="Segundo apellido"  placeholder="Segundo apellido" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="calle" type="text" label="Calle"  placeholder="Calle" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="poblacion" type="text" label="Población"  placeholder="Población" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="cp" type="number" maxLength="5"  label="Código postal"  placeholder="Código postal" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="provincia" type="text" label="Provincia"  placeholder="Provincia" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="pais"  type="text" label="Pais"  placeholder="Pais" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="tlfn1" type="number" maxLength="9" label="Teléfono 1: "  placeholder="Teléfono 1" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="tlfn2" type="number" maxLength="9" label="Teléfono 2: "  placeholder="Teléfono 2" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <s:submit value="Solicitar" cssClass="btn btn-default" />
                        </div>
                    </s:form>

                </div>
            </s:if> 
            <s:if test="#session.rol==3">
                <div class="panel-heading">Registro de empresa</div>
                <div class="panel-body" >

                    <s:form action="registro">
                        <s:hidden name="rol" value="3"/>
                        <div class="form-group" >
                            <s:textfield name="usuario" type="text" label="Nombre de usuario"   placeholder="usuario" cssClass="form-control" required="true"/>                                </div>
                        <div class="form-group" >
<s:textfield name="email" type="email" label="Email"   placeholder="email" cssClass="form-control" required="true"/>                        </div>
                        <div class="form-group" >
                            <s:textfield name="nif" label="NIF"  placeholder="NIF" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="nombre" label="Nombre de la empresa"  placeholder="Nombre de la empresa" cssClass="form-control" required="true"/>
                        </div>

                       <div class="form-group" >
                            <s:textfield name="calle" type="text" label="Calle"  placeholder="Calle" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="poblacion" type="text" label="Población"  placeholder="Población" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="cp" type="number" maxLength="5"  label="Código postal"  placeholder="Código postal" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="provincia" type="text" label="Provincia"  placeholder="Provincia" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="pais"  type="text" label="Pais"  placeholder="Pais" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="tlfn1" type="number" maxLength="9" label="Teléfono 1: "  placeholder="Teléfono 1" cssClass="form-control" required="true"/>
                        </div>
                        <div class="form-group" >
                            <s:textfield name="tlfn2" type="number" maxLength="9" label="Teléfono 2: "  placeholder="Teléfono 2" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <s:submit value="Solicitar" cssClass="btn btn-default" />
                        </div>
                    </s:form>

                </div>
            </s:if>
        </div>


    </div>
</div>