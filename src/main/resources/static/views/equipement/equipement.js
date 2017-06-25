/**
 * gestion du bilan des équipements
 */

app.config(function($stateProvider) {
	$stateProvider.state('equipement', {
		url : '/equipement_bilan',
		templateUrl : 'views/equipement/equipement.html',
		controller : 'equipementCtrl'
	});
}).controller('equipementCtrl', function($scope, $state) {
	$scope.addequipement = function() {

	};
	$scope.equipement;
})
