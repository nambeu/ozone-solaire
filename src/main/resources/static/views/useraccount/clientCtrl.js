/**
 * Created by nambeu on 22/06/17.
 */

app.controller("clientCtrl", function($scope, $state, ClientService) {
	$scope.client = new ClientService;
	$scope.listeclient = ClientService.query();
	$scope.createclient = function() {
		console.log($scope.client);
		if($scope.client.firstName == null){
			$scope.client.firstName = "pas defini";
		}
		$scope.client.$save( function() {
			console.log($scope.client)
			$state.go("manuelcity");
		});
	};
	
	
});
