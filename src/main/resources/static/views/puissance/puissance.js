/**
 * bilan des puissances de l'installation
 */

app.config(function($stateProvider) {
	$stateProvider.state("puissance", {
		url : "/puissance_bilan",
		templateUrl : "views/puissance/puissance.html",
		controller : "puissanceCtrl"
	});
})
.controller("puissanceCtrl", function($scope) {
	$scope.puissance;
});