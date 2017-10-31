angular.module('authModule')
.factory('authService', function($http, $cookies) {
	var service = {};
	
	var saveToken = function(user) {
		$cookies.put('todo_id', user.id);
		$cookies.put('todo_email', user.email);
	}
	
	service.getToken = function() {
		var token = {};
		
		token.id = $cookies.get('todo_id');
		token.email = $cookies.get('todo_email');
		
		return token;
	}
	
	var removeToken = function() {
		$cookies.remove('todo_id');
		$cookies.remove('todo_email');
	}
	
	service.register = function(user) {
		return $http({
			method : 'POST',
			url : 'rest/auth/register',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : user
		})
		.then(function(res) {
			saveToken(res.data);
			return res;
		})
	}
	
	service.login = function(user) {
		return $http({
			method : 'POST',
			url : 'rest/auth/login',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : user
		})
		.then(function(res) {
			saveToken(res.data);
			return res;
		})
	}
	
	service.logout = function() {
		return $http({
			method : 'POST',
			url : 'rest/auth/logout'
		})
		.then(function(res) {
			removeToken();
			return res;
		})
	}
	
	
	return service;
})
