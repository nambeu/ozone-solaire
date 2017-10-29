/**
 *  recueil des besoins en Eau
 */

app.config(function($stateProvider){
	 $stateProvider.state("besoins", {
		 url:"/parametre",
		 templateUrl : "views/besoin/parametre.html",
		 controller : "parametreCtrl"
	 });
});

app.factory("parametreService", function($resource){
	return $resource("ozone/api/alimentationDomestique",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	
		 }
		 });
});

app.controller("parametreCtrl", function($scope){
	
});