

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html ng-app="mainApp">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

         <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
         <script src="js/mainApp.js" type="text/javascript"></script>
        <script src="js/mainController.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-controller="mainController">
        <!------------------------- Header--------------------------------------->
        <div class="container">
            <div class="col-md-12">        
                <div class="col-md-6 ">    
                    <img src="img/logo.jpg" alt="andaser"/>
                </div> 
                <div class="col-md-6">
                    <div class="col-md-4">
                        <img src="img/masquelack.jpg" alt="masquelack" class="distribuidores"/>
                    </div>
                    <div class="col-md-4">
                        <img src="img/adinor.jpg" alt="adinor" class="distribuidores"/>
                    </div>
                    <div class="col-md-4">
                        <img src="img/sia.png" alt="sia" class="distribuidores"/>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------------Menú--------------------------------->
        <div ng-include="'views/Menu.jsp'"></div>
        <!-----------------Menú lateral administrador----------------------->
        <div ng-include="'views/menuAdmin.jsp'"></div>
        <!----------------- Galería ------------------------->
        <!--<div ng-include="'views/galeria.jsp'"></div>-->
        <s:url action="adminCategoria" var="adminCat">
            
        </s:url>
        <s:a href="%{adminCat}">Administrar Categorías</s:a>
        <!----------------Footer------------------->
        <div ng-include="'views/footer.jsp'"></div>
   

 
  
  
    </body>
</html>
