

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html ng-app="mainApp">
    <head>
       
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> <!--
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-route.js" type="text/javascript"></script>-->
      
     
       <script src="js/bootstrap.js" type="text/javascript"></script>
       <script src="js/angular.min.js" type="text/javascript"></script>
       
       <script src="js/angular-route.min.js" type="text/javascript"></script>
       
         <script src="js/mainApp.js" type="text/javascript"></script>
        <script src="js/mainController.js" type="text/javascript"></script>
        <script src="js/controllers.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-controller="mainController">
     
       
        
        <!------------------------- Header--------------------------------------->
        <div ng-include="'views/header.jsp'"></div>
        <!----------------------------Menú--------------------------------->
        <div ng-include="'views/Menu.jsp'"></div>
        <!-----------------Menú lateral administrador----------------------->
         <s:if test="#session.usuario.rol==1">
            <div ng-include="'views/menuAdmin.jsp'"></div>
        </s:if>
      
        <!----------------- Galería ------------------------>
        <div class="container" style="padding:2%">
            <div class="row">
               
                   <div ng-include="'<s:property value="#session.vista"/>'"></div>
                <!--<div ng-view></div>-->
                   
            </div>
        </div>
    

       
       
            
        <!----------------Footer------------------->
        <div ng-include="'views/footer.jsp'"></div>
   

 
  
  
    </body>
</html>
