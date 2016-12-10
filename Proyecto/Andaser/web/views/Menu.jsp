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
                                
                                <s:if test="%{subcategoria!=null}">
                                     <li class="dropdown">
                                         <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><s:property value="nombre"/> <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <s:iterator value="subcategoria">
                                        <li><a href="#"><s:property value="nombreSubCat"/></a></li>
                                    </s:iterator>
                                </ul>
                            </li>
                                </s:if>
                                <s:else>
                                     <li><a href="#"><s:property value="nombre"/></a></li>
                                </s:else>
                                    </s:iterator>
                           
                        </ul>
                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Buscar...">
                            </div>
                            <button type="submit" class="btn btn-default">Enviar</button>
                        </form>
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


