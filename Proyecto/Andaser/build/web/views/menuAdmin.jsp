<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
  <s:if test="#session.login=='admin'">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3 col-md-3">
                        <div class="panel-group" id="menu-admin">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <p>Administración de categorías</p>
                                    <p>Administración de subcategorías</p>
                                    <p>Administración de productos</p>
                                    <p>Administración de usuarios</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>              
            </div>            
        </s:if>