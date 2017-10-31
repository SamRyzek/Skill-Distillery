angular.module('appModule')
.filter('incomplete', function() {
	return function(todos, showComplete) {
		if (showComplete) {
			return todos;
		}
		return todos.filter(function(t) {
			return !t.completed;
		})
	}
})