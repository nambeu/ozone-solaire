/**
 *  Dimension d'un panneau
 */

app.config(function($stateProvider){
	$stateProvider.state("dimension", {
		url:"/dimension",
		templateUrl : "views/dimensionpanneau/dimension.html",
		controller :"dimensionCtrl"
	})
});

app.config(function($stateProvider){
	$stateProvider.state("dimensionPompage", {
		url:"/dimension",
		templateUrl : "views/dimensionpanneau/dimensionPompage.html",
		controller :"dimensionCtrl"
	})
});

app.factory("DimensionService", function($resource){
	return $resource("/ozone/api/dimensionpanneau/:id", {id: '@_id'},{
		update : {
			method : 'PUT'
		}
	})
});

app.controller("dimensionCtrl", function($scope, DimensionService, $state){
	 $scope.dimension = new DimensionService;
	 $scope.dimensionvalid = function(){
		 $scope.dimension.$save(function(){
			 console.log($scope.dimension);
			 $state.go('alimentation');
	 });
	 };
	 
	 $scope.dimensionvalidPompage = function(){
		 $state.go('pompage');
	 }
});