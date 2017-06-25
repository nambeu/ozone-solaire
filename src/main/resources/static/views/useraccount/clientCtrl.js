/**
 * Created by nambeu on 22/06/17.
 */

 app.controller("clientCtrl", function($scope, $state){
    $scope.createclient = function(){
       $state.go();
    }
 })
