/**
 * Created by nambeu on 22/06/17.
 */

 app.config(function($stateProvider){
    $stateProvider.state('login',{
      url : "/login",
      templateUrl: 'views/login/login.html',
      controller : "loginCtrl"
    });
 })
