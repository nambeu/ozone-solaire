/*
 *  gestions des controllers de la ville
 */



app.controller("cityCtrl", function($scope){
	 $scope.citySearch = function(name){
		 
	 }
});

app.controller("manuelCtrl", function($scope, CityService, $state){
	$scope.city = new CityService;
	 $scope.valid = function(){
		 $scope.city.$save( function(){
			 console.log($scope.city);
			 $state.go('equipementManuel');
		 });
	 };
	
});