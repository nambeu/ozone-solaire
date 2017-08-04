/**
 * gestion du bilan des équipements
 */

app.config(function($stateProvider) {
	$stateProvider.state('equipement', {
		url : '/equipement_bilan',
		templateUrl : 'views/equipement/equipement.html',
		controller : 'equipementCtrl'
	});
});

app.factory("EquimentFactory", function($resource){
	return $resource("/ozone/api/energie/:id", {id:'@_id'},{
		update: {
			method : 'PUT'
		}
	});
}) ;

app.controller(
				'equipementCtrl',
				function($scope, $state, EquimentFactory) {
					$scope.equip = new EquimentFactory;
					$scope.addequipement = function() {
						$scope.equip.energieMax = (($scope.equipement.televiseur.puissance * $scope.equipement.televiseur.quantite)
								+ ($scope.equipement.refrigerateur.puissance * $scope.equipement.refrigerateur.quantite)
								+ ($scope.equipement.climatiseur.puissance * $scope.equipement.climatiseur.quantite)
								+ ($scope.equipement.congelateur.puissance * $scope.equipement.congelateur.quantite)
								+ ($scope.equipement.radio.puissance * $scope.equipement.radio.quantite)
								+ ($scope.equipement.lampe.puissance * $scope.equipement.lampe.quantite)
								+ ($scope.equipement.destop.puissance * $scope.equipement.destop.quantite)
								+ ($scope.equipement.modem.puissance * $scope.equipement.modem.quantite)
								+ ($scope.equipement.laptop.puissance * $scope.equipement.laptop.quantite) + ($scope.equipement.autre.puissance * $scope.equipement.autre.quantite));

						$scope.equip.energie = (($scope.equipement.televiseur.puissance
								* $scope.equipement.televiseur.quantite * $scope.equipement.televiseur.temps)
								+ ($scope.equipement.refrigerateur.puissance
										* $scope.equipement.refrigerateur.quantite * $scope.equipement.refrigerateur.temps)
								+ ($scope.equipement.climatiseur.puissance
										* $scope.equipement.climatiseur.quantite * $scope.equipement.climatiseur.temps)
								+ ($scope.equipement.congelateur.puissance
										* $scope.equipement.congelateur.quantite * $scope.equipement.congelateur.temps)
								+ ($scope.equipement.radio.puissance
										* $scope.equipement.radio.quantite * $scope.equipement.radio.temps)
								+ ($scope.equipement.lampe.puissance
										* $scope.equipement.lampe.quantite * $scope.equipement.lampe.temps)
								+ ($scope.equipement.destop.puissance
										* $scope.equipement.destop.quantite * $scope.equipement.destop.temps)
								+ ($scope.equipement.modem.puissance
										* $scope.equipement.modem.quantite * $scope.equipement.modem.temps)
								+ ($scope.equipement.laptop.puissance
										* $scope.equipement.laptop.quantite * $scope.equipement.laptop.temps) + ($scope.equipement.autre.puissance
								* $scope.equipement.autre.quantite * $scope.equipement.autre.temps));
                              
						     console.log($scope.equip.energieMax);
					         console.log("energie :" + $scope.equip.energie);
						  $scope.equip.$save(function(){
							  console.log($scope.equip.energieMax);
						      console.log("energie :" + $scope.equip.energie);
						      $state.go("puissance");
						  });
						
						
					};
					$scope.equipement;
				})
