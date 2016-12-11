 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
  
            <div class="container ">
    <nav class="navbar navbar-default menu">
        <div class="container-fluid">
             <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
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
                                 <s:param name="service">adminPed</s:param>
                                    </s:url>
                                    <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminCategoria}">Administrar Categorías</s:a></li>
                                    <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminSubCategoria}">Administrar Subcategorías</s:a></li>
                                    <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminProducto}">Administrar Productos</s:a></li>
                                    <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminUsuario}">Administrar Usuarios</s:a></li>
                                    <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirectAdminPedido}">Administrar Pedidos</s:a></li>
                                    
                            </ul>
                   </div>
        </div>
    </nav>
</div>
