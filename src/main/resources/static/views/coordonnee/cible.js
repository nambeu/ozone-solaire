/**
 * la cible etant la ville dans laquelle les travaux s'effectueront...
 */

app.config(function($stateProvider){
	$stateProvider.state("city",{
		url:"/city",
		templateUrl : "views/coordonnee/cible.html",
		controller : "cityCtrl"
	})
	.state("manuelcity", {
		url:"/city_manuel",
		templateUrl : "views/coordonnee/cityManuel.html",
		controller : "manuelCtrl"
	});
});


app.factory("CityService", function($resource){
	return $resource("/ozone/api/location", {id : '@_id'}, {
		update : {
			method : 'PUT'
		}
	})
})