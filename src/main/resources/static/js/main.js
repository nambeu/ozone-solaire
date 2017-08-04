var app = angular.module('myApp', ['ui.router','ngResource']);

app.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('home', {
		url : '/',
		templateUrl : 'views/main/home.html'
	});

	$urlRouterProvider.otherwise('/');
});

/*
 
 app.controller("navigation", function($rootScope,$state,$scope, $http, $location){
	 
	$http.get("/user").then(
			 function success(data) {
				 if(data){
					 $rootScope.authenticate = true;
				 }
			 } , function error(response){
				 console.log("pas de données");
				 $rootScope.authenticate = false;
			 });
	
	$scope.logout = function(){
		 $http.post("logout", {}).success(function(data){
			 $rootScope.authenticate = false;
			 $location.path("/login") ;
		 }).error(function(){
			 $rootScope.authenticate = true;
		 })
	}
})
 
 */

