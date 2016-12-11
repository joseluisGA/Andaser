<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>


<div class="container ">
    <nav class="navbar navbar-default menu">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="navbar-brand menu"><s:a  href="inicio.action">Andaser</s:a></div>
                </div>
                <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    <s:iterator value="#application.aCat">
                        <s:url action="../Redireccion" var="urlRedirectProCat" escapeAmp="false">
                            <s:param name="template">ProductoCat</s:param>
                            <s:param name="idCat"><s:property value="id"/></s:param>
                        </s:url>
                        <s:if test="%{subcategoria!=null}">

                            <li class="dropdown">
                                <a href="<s:property value='%{urlRedirectProCat}'/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><s:property value="nombre"/> <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <s:iterator value="subcategoria">
                                        <s:url action="../Redireccion" var="urlRedirectProSubCat" escapeAmp="false">
                                            <s:param name="template">ProductoSubCat</s:param>
                                            <s:param name="idSubCat"><s:property value="id_subCat"/></s:param>

                                        </s:url>
                                        <li><a href="<s:property value='%{urlRedirectProSubCat}'/>"><s:property value="nombreSubCat"/></a></li>
                                        </s:iterator>
                                </ul>
                            </li>
                        </s:if>
                        <s:else>
                            <li><a href="<s:property value='%{urlRedirectProCat}'/>"><s:property value="nombre"/></a></li>
                            </s:else>
                        </s:iterator>

                </ul>
                <s:form action="Redireccion" cssClass="navbar-form navbar-left form-horizontal"  theme="simple">
                    <div class="form-group">
                        <input type="text" name="busqueda"  class="form-control" placeholder="Buscar..." />
                        <s:submit name="template" value="Buscar" cssClass="btn btn-default"/>
                    </div>

                </s:form>
                <s:url action="../AdminPedido.action" var="urlMostrarPed">
                    <s:param name="service">mostrar</s:param>

                </s:url>
                <div class="navbar-left" ><s:a href="%{urlMostrarPed}"><img src="img/carro.png" alt="" class="carro"/>
                        <s:if test="#session.pedido==null">
                            0
                        </s:if>
                        <s:else>
                            <s:property value="#session.pedido.array_ped.size()"/>
                        </s:else>
                    </s:a>
                </div>
                <ul class="nav navbar-nav" >
                    <s:if test="#session.usuario==null">
                        <s:url action="../Redireccion.action" var="urlRedirect">
                            <s:param name="template">login</s:param>
                        </s:url>
                        <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlRedirect}">Acceso clientes</s:a></li>
                        </s:if>
                        <s:else>
                        <li><div  style= "color:#08088e; font-weight: bold;">Bienvenido</div><s:property value="#session.usuario.nombre"/></li>
                            <s:url action="../LogOut.action" var="urlLogOut"/>
                        <li style= "color:#08088e; font-weight: bold;"><s:a href="%{urlLogOut}">Cerrar Sesión</s:a></li>
                        </s:else>


                </ul>
            </div>
        </div>
    </nav>
</div>


