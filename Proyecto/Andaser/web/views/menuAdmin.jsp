 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
  
            <div class="container">
                <div class="row">
                    <div class="col-sm-3 col-md-3">
                        <div class="panel-group" id="menu-admin">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                     <s:url action="../AdminCategoria.action" var="urlRedirectAdminCategoria">
                                 <s:param name="template">adminCat</s:param>
                                    </s:url>
                                 
                                 <s:url action="../AdminSubCategoria.action" var="urlRedirectAdminSubCategoria">
                                 <s:param name="template">adminSubCat</s:param>
                                    </s:url>
                                    <s:url action="../AdminProducto.action" var="urlRedirectAdminProducto">
                                 <s:param name="template">adminProducto</s:param>
                                    </s:url>
                                    <s:url action="../AdminUsuario.action" var="urlRedirectAdminUsuario">
                                 <s:param name="template">adminUsu</s:param>
                                    </s:url>
                                    <s:url action="../AdminPedido.action" var="urlRedirectAdminPedido">
                                 <s:param name="template">adminPed</s:param>
                                    </s:url>
                                    <p style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminCategoria}">Administrar Categorías</s:a></p>
                                    <p style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminSubCategoria}">Administrar Subcategorías</s:a></p>
                                    <p style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminProducto}">Administrar Productos</s:a></p>
                                    <p style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminUsuario}">Administrar Usuarios</s:a></p>
                                    <p style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminPedido}">Administrar Pedidos</s:a></p>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>              
            </div>            