

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html ng-app="mainApp">
    <head>
       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/angular.min.js" type="text/javascript"></script>
        <script src="js/angular-route.min.js" type="text/javascript"></script>
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
         <script src="js/mainApp.js" type="text/javascript"></script>
        <script src="js/mainController.js" type="text/javascript"></script>
        <script src="js/controllers.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-controller="mainController">
        <!------------------------- Header--------------------------------------->
        <div ng-include="'views/header'"></div>
        <!----------------------------Menú--------------------------------->
        <div ng-include="'views/Menu.jsp'"></div>
        <!-----------------Menú lateral administrador----------------------->
        <!--<div ng-include="'views/menuAdmin.jsp'"></div>-->
        <!----------------- Galería ------------------------>
        <div class="container" style="padding:2%">
            <div class="row">
               
                   <div ng-view></div>
                   
            </div>
        </div>
    

       
       
            
        <!----------------Footer------------------->
        <div ng-include="'views/footer.jsp'"></div>
   

 
  
  
    </body>
</html>
