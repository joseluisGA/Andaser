<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12" style="padding:2%">
    <div class="content col-md-10 col-md-push-1" style="background-color: white;">
       
        <h2>Modificar producto: <s:property value="#application.pro.nombre"/></h2>
            <s:form action="AdminProducto" cssClass="form-horizontal" theme="simple">

                <div class="form-group" >
                    <s:textfield name="REF" value="%{#application.pro.REF}" label="REF"  placeholder="REF" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="nombre" value="%{#application.pro.nombre}" label="Nombre del producto"  placeholder="Nombre" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textarea name="descripcion" value="%{#application.pro.descripcion}" label="Descripción"  placeholder="Descripción" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aCat.{nombre}" name="nombreCat" label="Categoría"  placeholder="Categoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aSubCat.{nombreSubCat}" name="nombreSubCat" label="Subcategoría"  placeholder="Subcategoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" value="<s:property value='#application.pro.precio1'/>" name="precio1" label="Precio particular"  placeholder="Precio particular" class="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" value="<s:property value='#application.pro.precio2'/>" name="precio2" label="Precio empresa"  placeholder="Precio empresa" class="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="ficha" value="#application.pro.ficha" label="Ficha" placeholder="Ficha" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="imagen" value="#application.pro.imagen" label="Imagen" placeholder="Imagen" cssClass="form-control"/>
                </div>
                    <s:hidden name="detalles" value="true"/>
                <div class="form-group">
                    <s:submit name="service" value="modificar" cssClass="btn btn-default" />
                </div>


            </s:form>
       

    </div>
</div>