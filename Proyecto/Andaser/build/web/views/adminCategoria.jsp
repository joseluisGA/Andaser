<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >

    <div class="col-md-3">
        <h3>Borrar Categoría</h3>

        <s:iterator value="#application.aCat">
            <s:form action="AdminCategoria" cssClass="form-horizontal" theme="simple">
                <div class="col-md-4">Nombre: </div> 
                <div class="col-md-4"><s:property value="nombre"/></div>
                <s:hidden value="%{id}" name="id"/>
                <s:hidden name="service" value="borrar"/>
                <div class="col-md-4"><s:submit value="Borrar"  cssClass="btn btn-default"/><hr/></div>
                </s:form>

        </s:iterator>



    </div>
    <div class="col-md-3">
        <h3>Nueva categoría</h3>
        <s:form action="AdminCategoria" cssClass="form-horizontal" theme="simple">

            Nombre <s:textfield name="nombre" label="Nombre" value="" cssClass="form-control" required="true" />
            <s:hidden name="service" value="insertar"/>
            <s:submit name="enviar" value="enviar" cssClass="btn btn-default"/>

        </s:form>
    </div>
    <div class="col-md-6">
        <h3>Modificar Categoría</h3>

        <s:iterator value="#application.aCat">
            <s:form action="AdminCategoria" cssClass="form-horizontal" theme="simple">
                <div class="col-md-2">Nombre: </div> 
                <div class="col-md-2"><s:property value="nombre"/></div>
                <s:hidden value="%{id}" name="id"/>
                <s:hidden name="service" value="modificar"/>
                <div class="col-md-8"><s:textfield name="nombre" value="%{nombre}" cssClass="form-control" required="true"/>

                    <s:submit value="Actualizar" cssClass="btn btn-default"/>
                    <hr/></div>

            </s:form>

        </s:iterator>
    </div>

</div>