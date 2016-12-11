<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >
       
        <h2>Modificar producto: <s:property value="#session.pro.nombre"/></h2>
        <div class="col-md-6 col-md-push-3">
            <s:form action="AdminProducto" cssClass="form-horizontal" theme="simple">

                <div class="form-group" >
                    <s:textfield name="REF" value="%{#session.pro.REF}" label="REF"  placeholder="REF" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="nombre" value="%{#session.pro.nombre}" label="Nombre del producto"  placeholder="Nombre" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:textarea name="descripcion" value="%{#session.pro.descripcion}" label="Descripción"  placeholder="Descripción" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aCat.{nombre}" name="nombreCat" label="Categoría"  placeholder="Categoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:select list="#session.aSubCat.{nombreSubCat}" name="nombreSubCat" label="Subcategoría"  placeholder="Subcategoría" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" value="<s:property value='#session.pro.precio1'/>" name="precio1" label="Precio particular"  placeholder="Precio particular" class="form-control"/>
                </div>
                <div class="form-group" >
                    <input type="number" value="<s:property value='#session.pro.precio2'/>" name="precio2" label="Precio empresa"  placeholder="Precio empresa" class="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="ficha" value="#session.pro.ficha" label="Ficha" placeholder="Ficha" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="imagen" value="#session.pro.imagen" label="Imagen" placeholder="Imagen" cssClass="form-control"/>
                </div>
                    <s:hidden name="detalles" value="true"/>
                <div class="form-group">
                    <s:submit name="service" value="modificar" cssClass="btn btn-default" />
                </div>


            </s:form>
        </div>

</div>