<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >

    <div class="col-md-7">
        <h3>Borrar o modificar Categoría</h3>

        <s:iterator value="#application.aCat">
            <s:form action="AdminCategoria" cssClass="form-horizontal" theme="simple">
                <div class="col-md-3">Nombre: </div> 
                <div class="col-md-3"><s:textfield name="nombre" value="%{nombre}" cssClass="form-control" required="true"/></div>
                <s:hidden value="%{id}" name="id"/>
                <div class="col-md-3"><s:submit name="service" value="modificar"  cssClass="btn btn-default"/></div>
                <div class="col-md-3"><s:submit name="service" value="borrar"  cssClass="btn btn-default"/></div>
                </s:form>
                <br/>
                <hr/>

        </s:iterator>



    </div>
    <div class="col-md-5">
        <h3>Nueva categoría</h3>
        <s:form action="AdminCategoria" cssClass="form-inline" theme="simple">

            Nombre <s:textfield name="nombre" label="Nombre" value="" cssClass="form-control" required="true" />
            <s:hidden name="service" value="insertar"/>
            <s:submit name="enviar" value="enviar" cssClass="btn btn-default"/>

        </s:form>
    </div>
    

</div>