angular.module('appModule')
.component('home', {
	templateUrl : 'app/appModule/home.component.html',
	controller : function($http, $location) {
		var vm = this;
		
	},
	controllerAs : 'vm'
})