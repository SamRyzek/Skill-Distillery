angular.module('appModule')
.component('modal', {
	templateUrl : 'app/appModule/modal.component.html',
	bindings : {
		resolve : '<',
	    close: '&',
	    dismiss: '&'
	},
	controller : function() {
		var vm = this;
		
		vm.list = ['apple', 'banana', 'coconut'];
		
		vm.submit = function() {
			vm.close({ $value : vm.selected })
		}
		
		vm.cancel = function() {
			vm.dismiss();
		}
	},
	controllerAs : 'vm'
})