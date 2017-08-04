/**
 * Created by nambeu on 22/06/17.
 */

app.controller("clientCtrl", function($scope, $state, ClientService) {
	$scope.client = new ClientService;
	$scope.createclient = function() {
		console.log($scope.client);
		$scope.client.$save( function() {
			console.log($scope.client)
			$state.go("city");
		});
	};
});
