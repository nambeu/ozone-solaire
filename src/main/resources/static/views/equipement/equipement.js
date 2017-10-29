/**
 * gestion du bilan des équipements
 */


app.config(function($stateProvider) {
	$stateProvider.state('equipement', {
		url : '/equipement_bilan',
		templateUrl : 'views/equipement/equipement.html',
		controller : 'equipementCtrl'
	}).state("equipementManuel", {
		url : '/equipement_manuel',
		templateUrl : 'views/equipement/equipementManuel.html',
		controller : "equipementCtrl"
	})
});

app.factory("EquimentFactory", function($resource) {
	return $resource("/ozone/api/energie/:id", {
		id : '@_id'
	}, {
		update : {
			method : 'PUT'
		}
	});
});

app.factory("MaterielFactory", function($resource) {
	return $resource("/ozone/api/addMaterielItems/:id", {
		id : '@_id'
	}, {
		update : {
			method : 'PUT'
		}
	});
});

app.factory("RemoveMateriel", function($resource) {
	return $resource("/ozone/api/removeMaterielItems/:id", {
		id : '@_id'
	}, {
		update : {
			method : 'PUT'
		}
	});
});

app
		.controller(
				'equipementCtrl',
				function($scope, $state, EquimentFactory, MaterielFactory,
						RemoveMateriel) {

					$scope.equip = new EquimentFactory;
					$scope.materiel = new MaterielFactory;
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
						$scope.equip.$save(function() {
							console.log($scope.equip.energieMax);
							console.log("energie :" + $scope.equip.energie);
							$state.go("puissance");
						});

					};

					$scope.equipement;
					$scope.equip.energie = 0;
					$scope.equip.energieMax = 0;
					// configuration des equipements manuellement
					$scope.materiels = MaterielFactory.query(function() {
						angular.forEach($scope.materiels, function(value) {
							$scope.equip.energieMax += value.puissanceMax;
							$scope.equip.energie += value.puissanceMaximun;
						})
					});
					// ajout d'un nouveau materiel
					$scope.addEquipment = function() {
						$scope.materiel.puissanceMax = $scope.materiel.puissance
								* $scope.materiel.quantite;
						$scope.materiel.puissanceMaximun = $scope.materiel.puissance
								* $scope.materiel.quantite
								* $scope.materiel.temps;

						$scope.materiel
								.$save(function() {
									$scope.materiels = MaterielFactory
											.query(function() {
												$scope.equip.energieMax = 0;
												$scope.equip.energie = 0;
												angular
														.forEach(
																$scope.materiels,
																function(value) {
																	$scope.equip.energieMax += value.puissanceMax;
																	$scope.equip.energie += value.puissanceMaximun;
																})
											});
									console.log($scope.materiel.puissanceMax);
									console
											.log($scope.materiel.puissanceMaximun);
								})
						console.log($scope.equip.energieMax);
						console.log($scope.equip.energie);
					}
					// validation de materiel
					$scope.validerMateriel = function() {
						$scope.equip.$save(function() {
							$state.go('puissance');
						});
					};
					
					$scope.removemat = new RemoveMateriel;
					// supprimer un materiel
					$scope.supprimer = function(designat) {
						console.log(designat);
						$scope.removemat.designation = designat;
						$scope.removemat.quantite = 1;
						$scope.removemat.temps = 1;
						$scope.removemat.puissance = 1;
						$scope.removemat.puissanceMax = 1;
						$scope.removemat.puissanceMaximun = 1;

						$scope.removemat
								.$save(function() {
									$scope.materiels = MaterielFactory
											.query(function() {
												$scope.equip.energieMax = 0;
												$scope.equip.energie = 0;
												angular
														.forEach(
																$scope.materiels,
																function(value) {
																	$scope.equip.energieMax += value.puissanceMax;
																	$scope.equip.energie += value.puissanceMaximun;
																})
											});
								});
					};

				})
