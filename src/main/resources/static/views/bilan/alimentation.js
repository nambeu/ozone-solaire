/**
 * Resultat de l'alimentation domestique
 */

app.config(function($stateProvider) {
	$stateProvider.state("alimentation", {
		url : "/bilan/:id",
		templateUrl : "views/bilan/alimentation.html",
		controller : "alimentationCtrl"
	});
});

app.factory("AlimentationService", function($resource) {
	 return $resource("ozone/api/alimentationDomestique",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
});

app.controller("alimentationCtrl", function($scope, AlimentationService) {
	$scope.alimentations = AlimentationService.query();
	
/*	$scope.tensionChamp = TensionChamp.query;
	$scope.nombrepvserie = Nombrepvserie.query();
	$scope.nombrepvparallele = Nombrepvparallele.query();
	$scope.nombrepvreel = Nombrepvreel.query();
	$scope.capacitetotalbatterie = Capacitetotalbatterie.query();
	$scope.nombreBatterieSerie = NombreBatterieSerie.query();
	$scope.nombreBatterieParallele = NombreBatterieParallele.query();
	$scope.nombreBatterie = NombreBatterie.query();
	$scope.intensiteEntree = IntensiteEntree.query();
	$scope.intensiteSortie = IntensiteSortie.query();
	$scope.puissanceOnduleur = PuissanceOnduleur.query();
*/ 
});