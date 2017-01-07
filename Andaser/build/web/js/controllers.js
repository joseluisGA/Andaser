mainApp.controller("inicio", ['$scope', function($scope){




}]);

mainApp.controller("acceso", ['$scope', '$http', '$location', function($scope, $http, $location){
               
		
                /*$scope.user=[];*/
                $scope.acceder = function(){
               /* var data = escape(angular.toJson($scope.user));
                */
                $http({
                    method:'POST',
                    url: 'login',
                   
                }).success(function(response){
                    $location.path('/inicio');
                });
                
                };
}]);

mainApp.controller("registro", ['$scope','$http', function($scope, $http){

//emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
//$scope.email ="";
//$scope.error ="";
//if(emailFormat.test($scope.email)){
//        $scope.registro.email.$error = "formato inválido";
//        $scope.error = "formato de email inválido";
//   
//}
////$scope.provincias;
////$http({
//		method: 'GET',
//		url: 'json/provincias.json'
//	}).success(function(data, status, headers, config) {
//		$scope.provincias = data;
//	}).error(function(data, status, headers, config){
//		alert("Error en petición. Estado HTTP: "+status);
//	});
//

}]);