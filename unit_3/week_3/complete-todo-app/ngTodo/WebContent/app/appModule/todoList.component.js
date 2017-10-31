angular.module('appModule')
.component('todoList', {
	templateUrl : 'app/appModule/todoList.component.html',
	controller : function($uibModal,todoService, $filter, $location, $routeParams, $rootScope, $scope) {
		var vm = this;
		
//		Variables		
		vm.selected = null;
		
		vm.editTodo = null;
		
	    vm.todos = [];
	    
	    $scope.$on('created', function(event, data){
	    		console.log(data);
	    })
	    
	    if (!isNaN($routeParams.id)) {
	    		todoService.show($routeParams.id)
	    			.then(function(res) {
	    				vm.selected = res.data;
	    				if (!res.data) {
	    					$location.path('_404');
	    				}
	    			})
	    			.catch(function(err) {
	    				if (err.status === 404) {
	    					$location.path('/_404');
	    				} else if (err.status >= 500) {
	    					$location.path('/error');
	    				}
	    			})
	    }
	    
//	    Behaviors
	    var reload = function() {
    			todoService.index()
    			.then(function(response){
    				vm.todos = response.data;
    				$rootScope.$broadcast('todoCount', {
    					incomplete : vm.getTodoCount()
    				})
    			});
	    }
	    
	    reload();
	    
	    vm.addTodo = function(todo) {
	    		todoService.create(todo)
	    		.then(function(response) {
	    			console.log(response);
	    			reload();
	    		});
	    };
	    
	    vm.getTodoCount = function() {
	    		return $filter('incomplete')(vm.todos).length;
	    };
	    
	    vm.displayTodo = function(todo) {
	    		vm.selected = todo;
	    };
	    
	    vm.displayTable = function() {
	    		vm.selected = null;
	    		$location.path('/todos');
	    };
	    
	    vm.setEditTodo = function() {
	    		vm.editTodo = angular.copy(vm.selected);
	    		
	    };
	    
	    vm.updateTodo = function(todo) {
	    		todoService.update(todo)
	    		.then(function(response) {
		    		vm.editTodo = null;
		    		reload();
	    		});
//	    		vm.todos = todoService.index();
	    		
	    };
	    
	    vm.deleteTodo = function(id) {
	    		todoService.destroy(id)
	    		.then(function(response) {
	    			reload();
	    		});
	    };
	    
//	    Private

	},
	controllerAs : 'vm'
})