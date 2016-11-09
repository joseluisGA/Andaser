var mainApp = angular.module("mainApp", ['ngRoute'])
.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){

	$routeProvider.
	when('/inicio', {
		templateUrl: 'views/galeria.jsp',
		controller: 'inicio'
	}).

	when('/accesoClientes', {
		templateUrl: 'views/acceso.jsp',
		controller: 'acceso'
	}).
                
	otherwise({
		redirectTo: '/inicio'

	});

}]);