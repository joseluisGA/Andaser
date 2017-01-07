<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div ng-controller="acceso">
       <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Nueva Contraseña</div>
                        <div class="panel-body" >
                            <s:if test="#session.error!=null">
                            <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <s:property value="#session.error"/>
                        </div>
                        </s:if>
                            <!-- Hace el login para los usuarios, si los datos son erróneos, salta un mensaje de error.-->
                            <s:form action="Redireccion">
                                
                                <div class="form-group" >
                                    <s:password name="pass1" label="Contraseña nueva"  placeholder="Contraseña" cssClass="form-control" required="true"/>
                                </div>
                                <div clasS="form-group">
                                    <s:password name="pass2" label="Repita la contraseña"  placeholder="Contraseña" cssClass="form-control" required="true"/>
                                </div>
                                <div class="form-group">
                                    <s:submit name="template" value="Cambiar" ng-disabled="" cssClass="btn btn-default" />
                                </div>
                               
                            </s:form>
                          
                        </div>
                    </div>
                </div>
</div>  
