<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12" style="padding:2%">
            <div class="content col-md-10 col-md-push-1" style="background-color: white;">
                <div class="col-md-3">
                    <h2>Borrar Categoría</h2>

                    <s:iterator value="array_Cat">
                       <s:form action="adminCategoria" cssClass="form-horizontal" theme="simple">
                            <div class="col-md-4">Nombre: </div> 
                            <div class="col-md-4"><s:property value="nombre"/></div>
                            <s:hidden value="%{id}" name="id"/>
                            <s:hidden name="admin" value="borrar"/>
                            <div class="col-md-4"><s:submit value="Borrar"/></div>
                        </s:form>
                        <hr/>
                    </s:iterator>



                </div>
                <div class="col-md-3">
                    <h2>Nueva categoría</h2>
                    <s:form action="adminCategoria" cssClass="form-horizontal" theme="simple">

                        <s:textfield name="nombre" label="Nombre" value="" />
                        <s:hidden name="admin" value="insertar"/>
                        <s:submit name="enviar" value="enviar"/>

                    </s:form>
                </div>
                <div class="col-md-6">
                    <h2>Modificar Categoría</h2>

                    <s:iterator value="categoria">
                        <s:form action="adminCategoria" cssClass="form-horizontal" theme="simple">
                            <div class="col-md-2">Nombre: </div> 
                            <div class="col-md-2"><s:property value="nombre"/></div>
                            <s:hidden value="%{id}" name="id"/>
                            <s:hidden name="admin" value="modificar"/>
                            <div class="col-md-8"><s:textfield name="texto" value=""/>
                            <s:submit value="Actualizar"/></div>
                            </s:form>
                        <hr/>
                    </s:iterator>
                </div>
            </div>
        </div>