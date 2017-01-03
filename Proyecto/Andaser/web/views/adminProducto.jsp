<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido">
    <div class="col-md-6">
        <h2>Borrar o Modificar Producto</h2>

        <s:iterator value="#session.aPro">
            <div class="col-md-12">

                <tr>
                    <s:form action="AdminProducto" cssClass="form-horizontal" theme="simple">

                    <div class="col-md-3">REF: <s:property value="REF"/> </div>

                    <div class="col-md-3">Nombre: <s:property value="nombre"/></div> 
                    <s:hidden value="%{REF}" name="REF"/>
                    <div class="col-md-3"><s:submit name="service" value="borrar" cssClass="btn btn-default"/></div>
                    <div class="col-md-3"><s:submit name="service"  value="modificar" cssClass="btn btn-default"/></div>

                </s:form>
            </div>
            <hr/>
        </s:iterator>



    </div>
    <div class="col-md-6 ">
        <h2>Nuevo Producto</h2>
            <s:form action="AdminProducto" >

                <div class="form-group" >
                    <s:textfield name="REF" type="text" label="REF"  placeholder="REF" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="nombre" type="text" label="Nombre del producto"  placeholder="Nombre" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textarea name="descripcion"  type="text"  label="Descripción" cols="30" rows="8" placeholder="Descripción" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aCat.{nombre}"  name="nombreCat" requiredLabel="true" emptyOption="true"  label="Categoría"  placeholder="Categoría" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:select list="#session.aSubCat.{nombreSubCat}" name="nombreSubCat" label="Subcategoría" requiredLabel="true" emptyOption="true" placeholder="Subcategoría" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="precio1" type="number"  label="Precio particular"  placeholder="Precio particular" cssClass="form-control" required="true"/>
                </div>

                <div class="form-group" >
                    <s:textfield name="precio2" type="number"  label="Precio empresa"  placeholder="Precio empresa" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:file name="ficha"  type="text"  label="Ficha"  placeholder="Ficha" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="imagen"  type="text"  label="Imagen" placeholder="Imagen" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <s:submit name="service" value="insertar" cssClass="btn btn-default" />
                </div>


            </s:form>
        </div>
    </div>
</div>

</div>
