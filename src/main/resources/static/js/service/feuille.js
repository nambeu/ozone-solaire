/*
 *  ensemble des services de l'alimentation domestique
 *  
 */ 
app.factory("TensionChamp", function($resource) {
	 return $resource("ozone/api/tensionchamp",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });

app.factory("Nombrepvserie", function($resource) {
	 return $resource("ozone/api/nombrepvserie",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("Nombrepvparallele", function($resource) {
	 return $resource("ozone/api/nombrepvparallele",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("Nombrepvreel", function($resource) {
	 return $resource("ozone/api/nombrepvreel",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("Capacitetotalbatterie", function($resource) {
	 return $resource("ozone/api/capacitetotalbatterie",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("NombreBatterieSerie", function($resource) {
	 return $resource("ozone/api/nombreBatterieSerie",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("NombreBatterieParallele", function($resource) {
	 return $resource("ozone/api/nombreBatterieParallele",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("NombreBatterie", function($resource) {
	 return $resource("ozone/api/nombreBatterie",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("IntensiteEntree", function($resource) {
	 return $resource("ozone/api/intensiteEntree",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("IntensiteSortie", function($resource) {
	 return $resource("ozone/api/intensiteSortie",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });
 
 app.factory("PuissanceOnduleur", function($resource) {
	 return $resource("ozone/api/puissanceOnduleur",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
 });

app.factory("PuissanceCrete", function($resource){
	 return $resource("ozone/api/crete/:id",{id:'@_id'}, {
		 update : {
			 method : 'PUT'	 
		 }
	 });
});