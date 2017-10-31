angular.module('appModule')
.component('navigation', {
	templateUrl : 'app/appModule/navigation.component.html',
	controller : function($location, authService, $scope, $uibModal) {
		var vm = this;
		
		vm.numIncomplete;
		
	    vm.loginModal = function() {
    			var modal = $uibModal.open({
    				animation : true,
    				component : 'modal',
    				resolve : {
    						title : function() {
    							return "Login Form";
    						}
    					}
    				});
    			
    			modal.result
    				.then(function(msg) {
    					console.log(msg);
    				})
	    }
		
		$scope.$on('todoCount', function(event, data) {
			vm.numIncomplete = data.incomplete;
		})
		
		vm.checkLogin = function() {
			if (authService.getToken().id) {
				return true;
			}
			return false;
		}
		
	    vm.warnUser = function() {
    			if (vm.numIncomplete > 10) {
    				return 'danger';
    			}
    			if (vm.numIncomplete > 5) {
    				return 'warn';
    			}
    			return 'success';
	    }
		
		vm.currentLocation = function() {
			switch($location.path()) {
				case '/' : 
					return 'Home';
					break;
				case '/about' : 
					return 'About';
					break;
				case '/contact' : 
					return 'Contact';
					break;
				default :
			}
		}
	},
	controllerAs : 'vm'
})