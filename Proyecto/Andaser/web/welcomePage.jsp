<%-- 
    Document   : cargarindex
    Created on : 26-abr-2016, 9:55:05
    Author     : Hose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html ng-app="mainApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <!-- Esta página es simplemente para que cargue el action al ir al index de la aplicación-->
        <s:action name="inicio" executeResult="true"> 
            
        </s:action>
    </body>
</html>
