/**
 * Created by nambeu on 22/06/17.
 */

app.config(function($stateProvider){
    $stateProvider.state("client", {
       url : "/client",
        templateUrl : "views/useraccount/client.html",
        controller : "clientCtrl"
    });
 })

