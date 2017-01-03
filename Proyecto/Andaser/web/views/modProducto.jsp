<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="col-md-12 contenido"  >
       
        <h2>Modificar producto: <s:property value="#session.pro.nombre"/></h2>
        <div class="col-md-6 col-md-push-3">
            <s:form action="AdminProducto" >
                <s:hidden name="REF" value="%{#session.pro.REF}"/>
                <div class="form-group" >
                    <s:textfield name="" value="%{#session.pro.REF}" label="REF"  placeholder="REF" cssClass="form-control" required="true" disabled="true"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="nombre" value="%{#session.pro.nombre}" label="Nombre del producto"  placeholder="Nombre" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textarea name="descripcion" value="%{#session.pro.descripcion}" type="text"  label="Descripción" cols="30" rows="8" placeholder="Descripción" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:select list="#application.aCat.{nombre}" name="nombreCat" requiredLabel="true" emptyOption="true" label="Categoría"  placeholder="Categoría" cssClass="form-control" />
                </div>
                <div class="form-group" >
                    <s:select list="#session.aSubCat.{nombreSubCat}" name="nombreSubCat" requiredLabel="true" emptyOption="true" label="Subcategoría"  placeholder="Subcategoría" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="precio1" type="number" value="%{#session.pro.precio1}"  label="Precio particular"  placeholder="Precio particular" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:textfield name="precio2" type="number" value="%{#session.pro.precio2}"  label="Precio empresa"  placeholder="Precio empresa" cssClass="form-control" required="true"/>
                </div>
                <div class="form-group" >
                    <s:file name="ficha"  label="Ficha" placeholder="Ficha" cssClass="form-control"/>
                </div>
                <div class="form-group" >
                    <s:file name="imagen"  label="Imagen" placeholder="Imagen" cssClass="form-control"/>
                </div>
                    <s:hidden name="detalles" value="true"/>
                <div class="form-group">
                    <s:submit name="service" value="modificar" cssClass="btn btn-default" />
                </div>


            </s:form>
        </div>

</div>