<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >
    <div class="col-md-3">
        <h2>Borrar Subcategoría</h2>

        <s:iterator value="#session.objeto">
            <s:form action="AdminSubCategoria" cssClass="form-horizontal" theme="simple">
                <div class="col-md-4">Nombre: </div> 
                <div class="col-md-4"><s:property value="nombreSubCat"/></div>
                <s:hidden value="%{id_subCat}" name="id"/>
                <s:hidden name="service" value="borrar"/>
                <div class="col-md-4"><s:submit value="Borrar"  cssClass="btn btn-default"/><hr/></div>
                </s:form>
            <hr/>
        </s:iterator>



    </div>
    <div class="col-md-3">
        <h2>Nueva Subcategoría</h2>
        <s:form action="AdminSubCategoria" cssClass="form-horizontal" theme="simple">

            <s:textfield name="nombre" label="Nombre" value="" cssClass="form-control" required="true"/>
            <s:select list="#application.aCat.{nombre}" name="nombreCat" cssClass="form-control" required="true"/>
            <s:hidden name="service" value="insertar"/>
            <s:submit name="enviar" value="enviar" cssClass="btn btn-default"/>

        </s:form>
    </div>
    <div class="col-md-6">
        <h2>Modificar Subcategoría</h2>

        <s:iterator value="#session.objeto">
            <s:form action="AdminSubCategoria" cssClass="form-horizontal" theme="simple">
                <p><div class="col-md-2">Nombre: </div> 
                <div class="col-md-2"><s:property value="nombreSubCat"/></div>
                <div class="col-md-4"><s:textfield name="nombre" value="%{nombreSubCat}" cssClass="form-control" required="true"/></div>
                <div class="col-md-4"><s:select list="#application.aCat.{nombre}" name="nombreCat"  cssClass="form-control" required="true"/>
                    <s:hidden value="%{id_subCat}" name="id"/>
                    <s:hidden name="service" value="modificar"/>

                    <s:submit value="Actualizar" cssClass="btn btn-default"/>
                    <hr/></div>
                </s:form>
            <hr/>
        </s:iterator>
    </div>
</div>
