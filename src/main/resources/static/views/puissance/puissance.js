/**
 * bilan des puissances de l'installation
 */

app.config(function($stateProvider) {
	$stateProvider.state("puissance", {
		url : "/puissance_bilan",
		templateUrl : "views/puissance/puissance.html",
		controller : "puissanceCtrl"
	});
});

// le service
app.factory("PuissanceService", function($resource){
	return $resource("/ozone/api/puissance", {id: '@_id'}, {
		update : {
			method : 'PUT'
		}
	})
})

//controller 
app.controller("puissanceCtrl", function($scope, $state, PuissanceService) {
	$scope.puissance = new PuissanceService;
	$scope.createPuissance = function(){
		console.log($scope.puissance);
		$scope.puissance.$save(function(){
			console.log($scope.puissance);
			$state.go('dimension');
		})
	}
});