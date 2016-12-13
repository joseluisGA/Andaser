<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div ng-controller="registro">
    <div class="col-md-6 col-md-offset-3">
        
        
                    <div class="panel panel-default">
                        <s:if test="#session.rol==2">
                        <div class="panel-heading">Registro de particular</div>
                        <div class="panel-body" >
                           
                            <s:form action="registro">
                                <s:hidden name="rol" value="2"/>
                                 <div class="form-group" >
                                    <s:textfield name="usuario" label="Nombre de usuario" ng-model="user.usuario" placeholder="usuario" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="email" label="Email" ng-model="user.email" placeholder="email" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="dni" label="DNI" ng-model="particular.dni" placeholder="DNI" cssClass="form-control" required="true"/>
                                </div>
                                 <div class="form-group" >
                                    <s:textfield name="nombre" label="Nombre" ng-model="particular.nombre" placeholder="Nombre" cssClass="form-control" required="true"/>
                                </div>
                                 <div class="form-group" >
                                    <s:textfield name="ape1" label="Primer apellido" ng-model="particular.ape1" placeholder="Primer apellido" cssClass="form-control" required="true"/>
                                </div>
                                 <div class="form-group" >
                                    <s:textfield name="ape2" label="Segundo apellido" ng-model="particular.ape2" placeholder="Segundo apellido" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="calle" label="Calle" ng-model="direccion.calle" placeholder="Calle" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="poblacion" label="Población" ng-model="direccion.pobla" placeholder="Población" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="cp" label="Código postal" ng-model="particular.cp" placeholder="Código postal" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="provincia" label="Provincia" ng-model="particular.prov" placeholder="Provincia" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="pais" label="Pais" ng-model="particular.pais" placeholder="Pais" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="tlfn1" label="Teléfono 1: " ng-model="particular.tlfn1" placeholder="Teléfono 1" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                     <s:textfield name="tlfn2" label="Teléfono 2: " ng-model="particular.tlfn2" placeholder="Teléfono 2" cssClass="form-control" required="true"/>
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
                                    <s:textfield name="usuario" label="Nombre de usuario" ng-model="user.usuario" placeholder="usuario" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="email" label="Email" ng-model="user.email" placeholder="email" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="nif" label="NIF" ng-model="empresa.nif" placeholder="NIF" cssClass="form-control" required="true"/>
                                </div>
                                 <div class="form-group" >
                                    <s:textfield name="nombre" label="Nombre de la empresa" ng-model="empresa.nombre" placeholder="Nombre de la empresa" cssClass="form-control" required="true"/>
                                </div>
                                
                                <div class="form-group" >
                                    <s:textfield name="calle" label="Calle" ng-model="direccion.calle" placeholder="Calle" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="poblacion" label="Población" ng-model="direccion.pobla" placeholder="Población" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="CP" label="Código postal" ng-model="particular.cp" placeholder="Código postal" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="provincia" label="Provincia" ng-model="particular.prov" placeholder="Provincia" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="pais" label="Pais" ng-model="particular.pais" placeholder="Pais" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                    <s:textfield name="tlfn1" label="Teléfono 1: " ng-model="particular.tlfn1" placeholder="Teléfono 1" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group" >
                                     <s:textfield name="tlfn2" label="Teléfono 2: " ng-model="particular.tlfn2" placeholder="Teléfono 2" cssClass="form-control" required="true"/>
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