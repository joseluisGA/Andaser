<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12" style="padding:2%">
    <div class="content col-md-10 col-md-push-1" style="background-color: white;">
        <div class="col-md-8">
            <h2>Borrar o Modificar Producto</h2>

            <s:iterator value="#application.aPro">
                <s:form action="AdminProducto" cssClass="form-horizontal" theme="simple">
                    <div class="col-md-1">REF: </div> 
                    <div class="col-md-2"><s:property value="REF"/></div>
                    <div class="col-md-2">Nombre: </div> 
                    <div class="col-md-2"><s:property value="nombre"/></div>
                    <s:hidden value="%{REF}" name="REF"/>
                    <div class="col-md-2"><s:submit name="service" value="borrar" cssClass="btn btn-default"/></div>
                    <div class="col-md-2"><s:submit name="service"  value="modificar" cssClass="btn btn-default"/></div>
                </s:form>
                <hr/>
            </s:iterator>



        </div>
        <div class="col-md-4">
            <h2>Nuevo producto</h2>
            <s:form action="AdminProducto" cssClass="form-horizontal" theme="simple">

                <div class="form-group" >
                    <s:textfield name="REF" label="REF" ng-model="producto.ref" placeholder="REF" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="nombre" label="Nombre del producto" ng-model="producto.nombre" placeholder="Nombre" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="descripcion" label="Descripción" ng-model="producto.desc" placeholder="Descripción" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aCat.{nombre}" name="nombreCat" label="Categoría" ng-model="producto.cat" placeholder="Categoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aSubCat.{nombreSubCat}" name="nombreSubCat" label="Subcategoría" ng-model="producto.subCat" placeholder="Subcategoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" name="precio1" label="Precio particular" ng-model="producto.precio1" placeholder="Precio particular" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" name="precio2" label="Precio empresa" ng-model="producto.precio2" placeholder="Precio empresa" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="ficha" label="Ficha" placeholder="Ficha" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="imagen" label="Imagen" placeholder="Imagen" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <s:submit name="service" value="insertar" cssClass="btn btn-default" />
                </div>


            </s:form>
        </div>

    </div>
</div>