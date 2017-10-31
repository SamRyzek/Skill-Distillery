angular.module('appModule')
.component('search', {
	templateUrl : 'app/appModule/search.component.html',
	controller : function($routeParams) {
		var vm = this;
		
		console.log($routeParams);
		
		vm.searchTerm = $routeParams.mySearchTerm;
		
	},
	controllerAs : 'vm'
})