<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="JavaScript">
function pregunta(){
    if (confirm('¿Estas seguro de borrar esta subcategoria?')){
       document.formulario.submit();
    }
}
</script> 

<div class="col-md-12 contenido"  >
    <div class="col-md-7">
        <h2>Borrar o modificar subcategoría</h2>

        <s:iterator value="#session.objeto">
            <s:form action="AdminSubCategoria" cssClass="form-horizontal" theme="simple" name="formulario">
                <div class="col-md-2">Nombre: </div> 
                <div class="col-md-3"><s:textfield name="nombre" value="%{nombreSubCat}" cssClass="form-control" required="true"/></div>
                <div class="col-md-3"><s:select list="#application.aCat.{nombre}"  emptyOption="true"  name="nombreCat"  cssClass="form-control" /></div>
                <s:hidden value="%{id_subCat}" name="id"/>
                
                <div class="col-md-2"><s:submit onclick="pregunta()" name="service" value="borrar"  cssClass="btn btn-default"/></div>
                <div class="col-md-2"><s:submit name="service" value="modificar"  cssClass="btn btn-default"/></div>
                </s:form>
              <br/>
              <hr/>
        </s:iterator>



    </div>
    <div class="col-md-5">
        <h2>Nueva Subcategoría</h2>
        <s:form action="AdminSubCategoria" >
            <div class="form-group">
            
            <s:textfield name="nombre" value="" label="Nombre"  placeholder="Nombre" cssClass="form-control" required="true"/>
            </div>
            <div class="form-group">
            <s:select list="#application.aCat.{nombre}" emptyOption="true" label="subcategoria" requiredLabel="true" name="nombreCat" cssClass="form-control" required="true"/>
            </div>
            <s:hidden name="service" value="insertar"/>
            <s:submit name="enviar" value="enviar" cssClass="btn btn-default"/>

        </s:form>
    </div>
   
</div>
