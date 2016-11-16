<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div ng-controller="acceso">
       <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Login</div>
                        <div class="panel-body" >
                            <s:if test="#session.errorlogin!=null">
                            <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <s:property value="#session.errorlogin"/>
                        </div>
                        </s:if>
                            <!-- Hace el login para los usuarios, si los datos son erróneos, salta un mensaje de error.-->
                            <s:form action="login">
                                
                                <div class="form-group" >
                                    <s:textfield name="user" label="Usuario" ng-model="user.nombre" placeholder="usuario" cssClass="form-control"/>
                                </div>
                                <div clasS="form-group">
                                    <s:password name="password" label="Contraseña" ng-model="user.password" placeholder="contraseña" cssClass="form-control"/>
                                </div>
                                <div class="form-group">
                                    <s:submit value="Acceder" cssClass="btn btn-default" />
                                </div>
                               
                            </s:form>
                            
                        </div>
                    </div>
                </div>
</div>  
