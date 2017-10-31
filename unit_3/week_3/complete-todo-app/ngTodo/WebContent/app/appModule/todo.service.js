angular.module('appModule')
.factory('todoService', function($http,$filter,authService,$location,$rootScope) {
	var service = {};
	
	var checkLogin = function() {
		if (authService.getToken().id) {
			return;
		}
		$location.path('/login');
	}
	
	service.index = function() {
		checkLogin();
		console.log(authService.getToken().id);
		return $http({
			method : 'GET',
			url : 'rest/user/' + authService.getToken().id + '/todo'
		})
	};
	
	service.show = function(id) {
		checkLogin();
		return $http({
			method : 'GET',
			url : 'rest/user/' + authService.getToken().id + '/todo/' + id
		})
	};
	
	service.create = function(todo) {
		checkLogin();
		todo.description = '';
		todo.completed = false;
		return $http({
			method : 'POST',
			url : 'rest/user/' + authService.getToken().id + '/todo',
			header : {
				'Content-Type' : 'application/json',
			},
			data : todo
		})
		.then(function(res) {
			$rootScope.$broadcast('created', {
				todo : res.data
			})
			return res;
		})
	};
	
	service.update = function(todo) {
		checkLogin();
		if (todo.completed) {
			todo.completeDate = $filter('date')(Date.now, "MM/dd/yyyy");
		} else {
			todo.completeDate = '';
		}
		return $http({
			method : 'PUT',
			url : 'rest/user/' + authService.getToken().id + '/todo/' + todo.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : todo
		})
	};
	
	service.destroy = function(id) {
		checkLogin();
		return $http({
			method : 'DELETE',
			url : 'rest/user/' + authService.getToken().id + '/todo/' + id
		})
	}
	
	return service;
})

