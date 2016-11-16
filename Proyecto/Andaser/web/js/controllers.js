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

mainApp.controller("adminCat", ['$scope', function($scope){




}]);