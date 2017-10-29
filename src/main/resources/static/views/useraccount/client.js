/**
 * Created by nambeu on 22/06/17.
 */

app.config(function($stateProvider){
    $stateProvider.state("client", {
       url : "/client",
        templateUrl : "views/useraccount/client.html",
        controller : "clientCtrl"
    });
 });

app.config(function($stateProvider){
    $stateProvider.state("listeClient", {
       url : "/listeclient",
        templateUrl : "views/useraccount/listeclient.html",
        controller : "clientCtrl"
    });
 });

app.factory("ClientService", function($resource){
	return $resource("/ozone/api/client/:id", {id: '@_id'},{
		update : {
			method : 'PUT'
		}
		
	});
});


