/**
 * Facture pour le module Alimentation domestique
 */

// configuration de la route
app.config(function($stateProvider) {
	$stateProvider.state("factureAlim", {
		url : "/factureAlim",
		templateUrl : "views/facture/facturealim.html",
		controller : "factureAlimCtrl"
	})
});

app.config(function($stateProvider) {
	$stateProvider.state("factureliste", {
		url : "/facture_liste",
		templateUrl : "views/facture/factureliste.html",
		controller : "factureAlimCtrl"
	})
});

// configuration des api
app.factory("Facture", function($resource) {
	return $resource("ozone/api/addFactureItems", {
		id : "@_id"
	}, {
		update : {
			method : 'PUT'
		}
	});
});

app.factory("FactureRemove", function($resource) {
	return $resource("ozone/api/removeFactureItems", {
		id : "@_id"
	}, {
		update : {
			method : 'PUT'
		}
	});
});

// le controller de la vue factureAlim
app
		.controller(
				"factureAlimCtrl",
				function($scope, Facture, $state, $location, FactureRemove,AlimentationService,ClientService,
						$window) {

					// redirection vers la page d'accueil
					$scope.report = function() {
						$window.location.href = "/";
					}
					
					$scope.listeclient = ClientService.query();
					
					 date = new Date();
					 
					 $scope.dateFacture = date.getDate();
					 $scope.month = date.getMonth()  + 1;
					 $scope.year = date.getFullYear();
					  

					$scope.montantTotal = 0;
					$scope.reference = 0;
					
					//recap des equipements du dimensionnement
					$scope.alimentations = AlimentationService.query();
					
					//affichage de la liste des clients
					$scope.clients = ClientService.query();
                   
					// affichage de la liste des equipements
					$scope.factures = Facture.query(function() {
						angular.forEach($scope.factures, function(value) {
							$scope.montantTotal += value.montantHt;
							console.log(value.montantHt);
						});
						$scope.taxe = ($scope.montantTotal * 19.25) / 100;
						$scope.montantTTC = $scope.taxe + $scope.montantTotal;
					});

					// Enregistrement d'un nouvel equipement
					$scope.facture = new Facture;

					$scope.add = function() {
						// $scope.tab = $scope.factures;
						$scope.facture.montantHt = ($scope.facture.prixUnitaire * $scope.facture.quantite);
						console.log($scope.factures.length);
						
						angular.forEach($scope.factures, function(value) {
							$scope.montantTotal += value.montantHt;
							console.log(value.montantHt);
						});
						$scope.taxe = ($scope.montantTotal * 19.25) / 100;
						$scope.montantTTC = $scope.taxe + $scope.montantTotal;

						console.log($scope.montantTotal);
						console.log($scope.taxe);
						console.log($scope.montantTTC);
                            // le save vers le serveur de cet equipement
						$scope.facture
								.$save(function() {
									$scope.factures = Facture
											.query(function() {
												$scope.montantTotal = 0;
												angular
														.forEach(
																$scope.factures,
																function(value) {
																	$scope.montantTotal += value.montantHt;
																	console
																			.log(value.montantHt);
																});
												$scope.taxe = ($scope.montantTotal * 19.25) / 100;
												$scope.montantTTC = $scope.taxe
														+ $scope.montantTotal;
											});
									// $scope.reference ++;
									console.log($scope.factures.length);
                                    
									console.log($scope.facture);
									console.log($scope.facture.quantite);
									console.log($scope.factures);
								});
						$location.path('/factureAlim');
					};

					// Suppression d'un equipement dans la facture
					$scope.fact = new FactureRemove;
					$scope.supprimer = function(designat) {
						console.log(designat);
						$scope.fact.designation = designat;
						$scope.fact.prixUnitaire = 1;
						$scope.fact.quantite = 1;
						$scope.fact.montantHT = 1;

						$scope.fact.$save(function() {
							$scope.factures = Facture.query(function(){
								$scope.montantTotal = 0;
								angular.forEach($scope.factures, function(value) {
									$scope.montantTotal += value.montantHt;
									console.log(value.montantHt);
								});
								console.log($scope.montantTotal);
								$scope.taxe = ($scope.montantTotal * 19.25) / 100;
								$scope.montantTTC = $scope.taxe + $scope.montantTotal;
							});
							console.log($scope.factures);
						});

					};
				});