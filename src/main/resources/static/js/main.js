var app = angular.module('myApp', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('home', {
		url : '/',
		templateUrl : 'views/main/home.html'
	});

	$urlRouterProvider.otherwise('/');
});
